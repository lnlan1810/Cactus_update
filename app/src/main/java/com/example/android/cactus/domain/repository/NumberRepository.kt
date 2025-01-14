package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.Number
import android.content.Context

object NumberRepository {

    fun numbers(context: Context): List<Number> {
        return arrayListOf(
            Number(0, "0", "Нуль", context.getString(R.string.zero), R.mipmap.zero, R.raw.zero),
            Number(1, "1", "Один", context.getString(R.string.one), R.mipmap.one, R.raw.one),
            Number(2, "2", "Два", context.getString(R.string.two), R.mipmap.two, R.raw.two),
            Number(3, "3", "Три", context.getString(R.string.three), R.mipmap.three, R.raw.three),
            Number(4, "4", "Четыре", context.getString(R.string.four), R.mipmap.four, R.raw.four),
            Number(5, "5", "Пять", context.getString(R.string.five), R.mipmap.five, R.raw.five),
            Number(6, "6", "Шесть", context.getString(R.string.six), R.mipmap.six, R.raw.six),
            Number(7, "7", "Семь", context.getString(R.string.seven), R.mipmap.seven, R.raw.seven),
            Number(8, "8", "Восемь", context.getString(R.string.eight), R.mipmap.eight, R.raw.eight),
            Number(9, "9", "Девять", context.getString(R.string.nine), R.mipmap.nine, R.raw.nine),
            Number(10, "10", "Десять", context.getString(R.string.ten), R.mipmap.ten, R.raw.ten),
            Number(11, "11", "Одиннадцать", context.getString(R.string.eleven), R.mipmap.eleven, R.raw.eleven),
            Number(12, "12", "Двенадцать", context.getString(R.string.twelve), R.mipmap.twelve, R.raw.twelve),
            Number(13, "13", "Тринадцать", context.getString(R.string.thirtteen), R.mipmap.thirteen, R.raw.thirteen),
            Number(14, "14", "Четырнадцать", context.getString(R.string.fourteen), R.mipmap.fourteen, R.raw.fourteen),
            Number(15, "15", "Пятнадцать", context.getString(R.string.fifteen), R.mipmap.fifteen, R.raw.fifteen),
            Number(16, "16", "Шестнадцать", context.getString(R.string.sixteen), R.mipmap.sixteen, R.raw.sixteen),
            Number(17, "17", "Семнадцать", context.getString(R.string.seventeen), R.mipmap.seventeen, R.raw.seventeen),
            Number(18, "18", "Восемнадцать", context.getString(R.string.eighteen), R.mipmap.eighteen, R.raw.eighteen),
            Number(19, "19", "Девятнадцать", context.getString(R.string.nineteen), R.mipmap.nineteen, R.raw.nineteen),
            Number(20, "20", "Двадцать", context.getString(R.string.twenty), R.mipmap.twenty, R.raw.twenty),
            Number(30, "30", "Тридцать", context.getString(R.string.thirty), R.mipmap.thirtty, R.raw.thirty),
            Number(40, "40", "Сорок", context.getString(R.string.forty), R.mipmap.fourty, R.raw.forty),
            Number(50, "50", "Пятьдесят", context.getString(R.string.fifty), R.mipmap.fifty, R.raw.fifty),
            Number(60, "60", "Шестьдесят", context.getString(R.string.sixty), R.mipmap.sixty, R.raw.sixty),
            Number(70, "70", "Семьдесят", context.getString(R.string.seventy), R.mipmap.seventy, R.raw.seventy),
            Number(80, "80", "Восемьдесят", context.getString(R.string.eighty), R.mipmap.eighty, R.raw.eighty),
            Number(90, "90", "Девяносто", context.getString(R.string.ninety), R.mipmap.ninety, R.raw.ninety),
            Number(100, "100", "Сто", context.getString(R.string.onehundred), R.mipmap.onehundred, R.raw.onehundred),
            Number(200, "200", "Двести", context.getString(R.string.twohundred), R.mipmap.twohundred, R.raw.twohundred),
            Number(300, "300", "Триста", context.getString(R.string.threehundred), R.mipmap.threehundred, R.raw.threehundred),
            Number(400, "400", "Четыреста", context.getString(R.string.fourhundred), R.mipmap.fourhundred, R.raw.fourhundred),
            Number(500, "500", "Пятьсот", context.getString(R.string.fivehundred), R.mipmap.fivehundred, R.raw.fivehundred),
            Number(600, "600", "Шестьсот", context.getString(R.string.sixhundred), R.mipmap.sixhundred, R.raw.sixhundred),
            Number(700, "700", "Семьсот", context.getString(R.string.sevenhundred), R.mipmap.sevenhundred, R.raw.sevenhundred),
            Number(800, "800", "Восемьсот", context.getString(R.string.eighthundred), R.mipmap.eighthundred, R.raw.eighthundred),
            Number(900, "900", "Девятьсот", context.getString(R.string.ninehundred), R.mipmap.ninehundred, R.raw.ninehundred),
            Number(1000, "1000", "Тысяча", context.getString(R.string.onethousand), R.mipmap.onethousand, R.raw.onethousand),
            Number(1000000, "1000000", "Миллион", context.getString(R.string.onemillion), R.mipmap.onemillion, R.raw.onemillion),
            Number(1000000000, "1000000000", "Миллиард", context.getString(R.string.onebillion), R.mipmap.onebillion, R.raw.onebillion)

        )
    }

    fun getNumber(context: Context, numberId: Int): Number? {
        return numbers(context).find { it.id == numberId }
    }
}