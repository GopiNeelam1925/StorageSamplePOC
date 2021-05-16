package com.techblue.storagesamplepoc

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@Suppress("SameParameterValue")
@SuppressLint("SimpleDateFormat")
fun dateToTimestamp(day: Int, month: Int, year: Int): Long =
    SimpleDateFormat("dd.MM.yyyy").let { formatter ->
        formatter.parse("$day.$month.$year")?.time ?: 0
    }