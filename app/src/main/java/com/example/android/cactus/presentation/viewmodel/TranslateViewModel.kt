package com.example.android.cactus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.cactus.data.respository.TranslateRepository
import com.example.android.cactus.domain.model.TranslateRequest
import com.example.android.cactus.domain.model.Translation
import kotlinx.coroutines.launch

class TranslateViewModel : ViewModel() {

    private val repository = TranslateRepository()

    private val _translations = MutableLiveData<List<Translation>>()
    val translations: LiveData<List<Translation>> get() = _translations

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun translateWord(input: String, targetLanguage: String) {
        val request = TranslateRequest(
            folderId = "",
            texts = listOf(input),
            targetLanguageCode = targetLanguage
        )

        viewModelScope.launch {
            try {
                val response = repository.translateWord(request)
                _translations.postValue(response.translations)
            } catch (e: Exception) {
                _errorMessage.postValue("Error: ${e.localizedMessage}")
            }
        }
    }
}
