package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.cactus.databinding.FragmentTranlateBinding
import com.example.android.cactus.presentation.viewmodel.TranslateViewModel
import androidx.lifecycle.Observer
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

class TranlateFragment : Fragment() {

    private var _binding: FragmentTranlateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TranslateViewModel by viewModels()

    private val LANGUAGE_CODES = listOf("en", "vi") // Supported languages

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTranlateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up Spinner with language list
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            listOf("English", "Vietnamese")
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLanguages.adapter = adapter

        // Observe LiveData from ViewModel
        viewModel.translations.observe(viewLifecycleOwner, Observer { translations ->
            val translatedText = translations.joinToString("\n") { it.text }
            binding.tvTranslatedText.text = translatedText
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })

        // Handle "Translate" button click
        binding.btnTranslate.setOnClickListener {
            val inputWord = binding.etInputWord.text.toString()
            val targetLanguage = LANGUAGE_CODES[binding.spinnerLanguages.selectedItemPosition]

            if (inputWord.isBlank()) {
                Toast.makeText(requireContext(), "Please enter the word to be translated", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.translateWord(inputWord, targetLanguage)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
