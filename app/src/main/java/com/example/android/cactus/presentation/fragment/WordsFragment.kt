package com.example.android.cactus.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentWordsBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.presentation.adapter.WordListAdapter
import com.example.android.cactus.presentation.ui.addCategory.AddCatDialog
import com.example.android.cactus.presentation.viewmodel.WordsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class WordsFragment : Fragment(), WordListAdapter.ItemClickListener,
    AddCatDialog.CategoryDialogListener {

    private var textToSpeech: TextToSpeech? = null
    private var _binding: FragmentWordsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<WordsViewModel>()
    private var listAdapter: WordListAdapter? = null
    private var fragmentManager: FragmentManager? = null
    private var catDialogFragment: DialogFragment? = null
    private var recyclerView: RecyclerView? = null
    private val CATEGORY = "category_arg"
    private val WORD = "word_arg"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordsBinding.inflate(inflater, container, false)
        lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        getCategoryFromArguments()
        initOnClick()
        initRecyclerView()
        initDialogFragment()
        observeWords()
        observeCategory()
        setRecyclerViewItemTouchListener()
        initTextToSpeech()
    }

    private fun initToolbar() {
        binding.wordsToolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun observeCategory() {
        viewModel.category.observe(viewLifecycleOwner) { category ->
            binding.wordsCategory.text = category.name
        }
    }

    private fun getCategoryFromArguments() {
        val category = arguments?.getParcelable<Category>(CATEGORY)
        category?.let {
            viewModel.setSelectedCategory(it)
            binding.wordsCategory.text = it.name
        }
    }

    private fun initOnClick() {
        binding.apply {
            wordsAddBtn.setOnClickListener {
                viewModel.category.value?.let { category ->
                    navigateToAddWordFragment(category, null)
                }
            }

            wordsStartBtn.setOnClickListener {
                viewModel.category.value?.let { category ->
                    navigateToLearnFragment(category)
                }
            }

            wordsCatEdit.setOnClickListener {
                showCatPopUp(wordsCatEdit)
            }
        }
    }

    private fun showCatPopUp(view: View) {
        PopupMenu(requireContext(), view).apply {
            inflate(R.menu.menu_category)
            show()

            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_cat_delete -> {
                        viewModel.deleteCategory()
                        parentFragmentManager.popBackStack()
                    }
                    R.id.menu_cat_rename -> showRenameDialog()
                }
                true
            }
        }
    }

    private fun initRecyclerView() {
        listAdapter = WordListAdapter(this).apply {
            submitList(ArrayList<Word>())
        }

        recyclerView = binding.wordsRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }
    }

    private fun initDialogFragment() {
        fragmentManager = parentFragmentManager
        catDialogFragment = AddCatDialog()
    }

    private fun observeWords() {
        viewModel.wordsOfCategory.observe(viewLifecycleOwner) { words ->
            if (words.isNullOrEmpty()) {
                binding.wordsAddImage.visibility = View.VISIBLE
                binding.wordsAddText.visibility = View.VISIBLE
                binding.wordsNumber.text = getString(R.string.zero_words)
            } else {
                renderUI(words)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderUI(listItems: List<Word>) {
        listAdapter?.setData(listItems)

        binding.apply {
            wordsStartBtn.visibility = View.VISIBLE
            wordsStartBtn.isEnabled = true
            wordsNumber.text =
                "(" + listItems.count { it.goodWord == 1 } +
                        " /" + listItems.size + ")"

            wordsAddImage.visibility = View.INVISIBLE
            wordsAddText.visibility = View.INVISIBLE
        }
    }

    private fun navigateToLearnFragment(category: Category) {
        val learnFragment = LearnFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY, category)
            }
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment, learnFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToAddWordFragment(category: Category, word: Word?) {
        val addWordFragment = AddWordFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY, category)
                putParcelable(WORD, word)
            }
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment, addWordFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onItemClick(position: Int) {
        val word = viewModel.wordsOfCategory.value?.get(position)
        viewModel.category.value?.let { navigateToAddWordFragment(it, word) }
    }

    override fun onListeningClick(position: Int) {
        val word = viewModel.wordsOfCategory.value?.get(position)?.translation
        word?.let { speakWord(it) }
    }

    private fun initTextToSpeech() {
        textToSpeech = TextToSpeech(requireContext()) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech?.language = Locale.forLanguageTag("ru")
            }
        }
    }

    private fun speakWord(word: String) {
        textToSpeech?.speak(word, TextToSpeech.QUEUE_FLUSH, null)
    }

    override fun onDialogPositiveClick(name: String) {
        viewModel.updateCategory(name)
        binding.wordsCategory.text = name
        catDialogFragment?.dismiss()
    }

    private fun showRenameDialog() {
        fragmentManager?.let { catDialogFragment?.show(it, getString(R.string.cat_dialog)) }
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                viewModel.deleteWord(position)
            }
        }
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(recyclerView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        textToSpeech?.shutdown()
        super.onDestroy()
    }
}
