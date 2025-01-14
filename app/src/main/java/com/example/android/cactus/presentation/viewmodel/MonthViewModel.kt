package com.example.android.cactus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MonthViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is month Fragment"
    }
    val text: LiveData<String> = _text
}