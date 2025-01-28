package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentAddWordBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.presentation.viewmodel.AddWordViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddWordFragment : Fragment(R.layout.fragment_add_word) {

    private var _binding: FragmentAddWordBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<AddWordViewModel>()
    private val CATEGORY = "category_arg"
    private val WORD = "word_arg"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        getDataFromArguments()
        initOnClick()
        observeSelectedWord()
        observeInputData()
    }

    private fun initToolbar() {
        binding.addToolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack() // Quay lại fragment trước đó
        }
    }

    private fun getDataFromArguments() {
        val category: Category? = arguments?.getParcelable(CATEGORY)
        val word: Word? = arguments?.getParcelable(WORD)

        category?.let { viewModel.setSelectedCategory(it) }
        word?.let { viewModel.setSelectedWord(it) }
    }

    private fun initOnClick() {
        binding.addWordBtn.setOnClickListener {
            viewModel.addOrUpdate(
                name = binding.addWordName.text.toString(),
                translation = binding.addWordTrans.text.toString()
            )
        }
    }

    private fun observeInputData() {
        viewModel.dataIsValid.observe(viewLifecycleOwner, { dataIsValid ->
            if (!dataIsValid) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.input_invalid_error_message),
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                parentFragmentManager.popBackStack() // Quay lại fragment trước đó
            }
        })
    }

    private fun observeSelectedWord() {
        viewModel.word.observe(viewLifecycleOwner, { word ->
            word?.let {
                binding.addWordName.setText(it.name)
                binding.addWordTrans.setText(it.translation)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
