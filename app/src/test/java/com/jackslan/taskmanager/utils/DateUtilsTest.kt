package com.jackslan.taskmanager.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

class DateUtilsTest {

    @Test
    fun getTodayDay_returnsCorrectDay() {
        val expectedDay = LocalDate.now().dayOfWeek.name
        val actualDay = DateUtils.getTodayDay()
        assertEquals(expectedDay, actualDay)
    }

    @Test
    fun getTodayDate_returnsCorrectDate() {
        val expectedDate = SimpleDateFormat("dd MMMM yyyy").format(Date())
        val actualDate = DateUtils.getTodayDate()
        assertEquals(expectedDate, actualDate)
    }

}