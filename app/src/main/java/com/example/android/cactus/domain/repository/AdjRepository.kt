package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.CommonWord


object AdjRepository {
    var id = 0;

    val commonWords = arrayListOf(
        CommonWord(
            id++, "большой",
            R.string.eight,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),


    )
}