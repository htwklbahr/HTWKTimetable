package com.lb.shared.utils.calendar

/**
 * Data class that defines a date.
 * @property [day] number of the day
 * @property [month] name of the month of the date
 * @property [year] year of the date
 */
data class DateUtil(
    val day: Int,
    val month: YearMonth,
    val year: Int
)