package com.example.android.cactus.presentation.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentLearnBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.presentation.viewmodel.LearnViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class LearnFragment : Fragment() {

    private val CATEGORY = "category_arg"

    private val viewModel by viewModel<LearnViewModel>()
    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!
    private var textToSpeech: TextToSpeech? = null
    private var soundCorrect: MediaPlayer? = null
    private var soundCompleted: MediaPlayer? = null
    private var soundWrong: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        lifecycle.addObserver(viewModel)

        initToolbar()
        getCategoryFromArguments()
        initOnClick()
        addObservers()
        initTextToSpeech()
        initSoundEffects()

        return binding.root
    }

    private fun initToolbar() {
        binding.learnToolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun initSoundEffects() {
        soundCorrect = MediaPlayer.create(requireContext(), R.raw.correct)
        soundCompleted = MediaPlayer.create(requireContext(), R.raw.success)
        soundWrong = MediaPlayer.create(requireContext(), R.raw.wrong)
    }

    private fun getCategoryFromArguments() {
        val category: Category? = arguments?.getParcelable(CATEGORY)

        category?.run {
            viewModel.setSelectedCategory(this)
        }
    }

    private fun initOnClick() {
        binding.apply {
            learnCard.setOnClickListener {
                initFlipCardAnim()
                viewModel.onCardClicked()
            }

            learnYesBtn.setOnClickListener {
                viewModel.onYesClicked()
                viewModel.getCurrentWord()
                soundCorrect?.start()
            }

            learnNoBtn.setOnClickListener {
                viewModel.onNoClicked()
                viewModel.getCurrentWord()
                soundWrong?.start()
            }

            learnPronunciation.setOnClickListener {
                speakWord()
            }
        }
    }

    private fun initFlipCardAnim() {
        val oa1 = ObjectAnimator.ofFloat(binding.learnCard, "scaleX", 1f, 0f)
        val oa2 = ObjectAnimator.ofFloat(binding.learnCard, "scaleX", 0f, 1f).apply {
            interpolator = AccelerateDecelerateInterpolator()
        }

        oa1.apply {
            interpolator = DecelerateInterpolator()
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    oa2.start()
                }
            })
        }
        oa1.start()
    }

    private fun addObservers() {
        observeCurrentWord()
        observeShowTranslationEvent()
        observeSessionsEvent()
    }

    private fun initTextToSpeech() {
        textToSpeech = TextToSpeech(requireContext()) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech?.language = Locale("ru", "RU")
            }
        }
    }

    private fun observeCurrentWord() {
        viewModel.currentWord.observe(viewLifecycleOwner) { word ->
            renderUI(word)
        }
    }

    private fun observeShowTranslationEvent() {
        viewModel.showTranslationEvent.observe(viewLifecycleOwner) { showTranslationEvent ->
            showTranslationOrWord(showTranslationEvent)
        }
    }

    private fun showTranslationOrWord(showTranslationEvent: Boolean) {
        binding.apply {
            if (showTranslationEvent) {
                learnTranslation.visibility = View.VISIBLE
                learnWord.visibility = View.INVISIBLE
            } else {
                learnTranslation.visibility = View.INVISIBLE
                learnWord.visibility = View.VISIBLE
            }
        }
    }

    private fun observeSessionsEvent() {
        viewModel.showSessionCompleteEvent.observe(viewLifecycleOwner) { sessionCompleted ->
            if (sessionCompleted) {
                viewModel.showSessionCompleteDone()
                startSuccessAnim()
                soundCompleted?.start()
                parentFragmentManager.popBackStack() // Quay lại fragment trước đó

            }
        }
    }

    private fun startSuccessAnim() {
        binding.apply {
            learnAnimation.visibility = View.VISIBLE
            learnWord.visibility = View.INVISIBLE
            learnTranslation.visibility = View.INVISIBLE
            learnCard.visibility = View.INVISIBLE
            learnNoBtn.visibility = View.INVISIBLE
            learnYesBtn.visibility = View.INVISIBLE
            learnPronunciation.visibility = View.INVISIBLE
            learnFlip.visibility = View.INVISIBLE
        }
    }

    private fun speakWord() {
        val wordToSpeech = binding.learnTranslation.text.toString()
        textToSpeech?.speak(wordToSpeech, TextToSpeech.QUEUE_FLUSH, null)
    }

    private fun renderUI(word: Word) {
        binding.apply {
            with(word) {
                learnWord.text = this.name
                learnTranslation.text = this.translation
            }
        }
    }

    override fun onPause() {
        if (textToSpeech?.isSpeaking == true) {
            textToSpeech?.stop()
        }
        super.onPause()
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
