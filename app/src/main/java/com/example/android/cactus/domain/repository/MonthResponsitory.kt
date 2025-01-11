package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.HandWriting
import com.example.android.cactus.domain.model.Month
object MonthRepository {
    val months = listOf(
        Month(0, "Январь", "January", R.raw.january),
        Month(1, "Февраль", "February", R.raw.february),
        Month(2, "Март", "March", R.raw.march),
        Month(3, "Апрель", "April", R.raw.april),
        Month(4, "Май", "May", R.raw.may),
        Month(5, "Июнь", "June", R.raw.june),
        Month(6, "Июль", "July", R.raw.july),
        Month(7, "Август", "August", R.raw.august),
        Month(8, "Сентябрь", "September", R.raw.september),
        Month(9, "Октябрь", "October", R.raw.october),
        Month(10, "Ноябрь", "November", R.raw.november),
        Month(11, "Декабрь", "December", R.raw.december)
    )
}
