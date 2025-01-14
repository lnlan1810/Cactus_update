package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.CommonWord


object VerbRepository {
    var id = 0;

    val words = arrayListOf(
        CommonWord(
            id++, "быть",
            R.string.man,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
    )

}