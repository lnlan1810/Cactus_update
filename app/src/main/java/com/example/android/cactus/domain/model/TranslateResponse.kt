package com.example.android.cactus.domain.model

data class TranslateResponse(
    val translations: List<Translation>
)

data class Translation(
    val text: String
)
