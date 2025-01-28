package com.example.android.cactus.domain.model

data class TranslateRequest(
    val folderId: String,
    val texts: List<String>,
    val targetLanguageCode: String
)