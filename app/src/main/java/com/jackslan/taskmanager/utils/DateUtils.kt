package com.jackslan.taskmanager.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

object DateUtils {

    fun getTodayDay(): String {
        return LocalDate.now().dayOfWeek.name
    }

    fun getTodayDate(): String {
        val formatedDate = SimpleDateFormat("dd MMMM yyyy")
        return formatedDate.format(Date())
    }

}