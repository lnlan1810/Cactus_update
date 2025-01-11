package com.example.android.cactus.domain.model

data class VocabularyCategory(
    val title: String,
    val meaning: String,
    val items: List<Vocabulary?>
)

data class Vocabulary(
    val word: String,
    val meaning: String,
    val imageRes: Int,           // ID hình ảnh
    val soundRes: Int
)
