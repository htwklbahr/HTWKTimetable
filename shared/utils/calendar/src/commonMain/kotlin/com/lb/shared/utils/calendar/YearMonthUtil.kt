package com.lb.shared.utils.calendar

import com.lb.shared.utils.calendar.LocalDateExt.isLeapYear
import kotlinx.datetime.*

/**
 * Data class that defines a the month of a year.
 * @property [year] year of the month
 * @property [monthNr] number of the month
 * @property [name] name of the month
 * @property [numberOfDays] number of days within the month
 */
data class YearMonth(
    val year: Int,
    val monthNr: Int,
) {
    constructor(date: LocalDate) : this(
        year = date.year,
        monthNr = date.monthNumber
    )

    val name = Month(monthNr).name

    val numberOfDays = when (this.monthNr) {
        2 -> if (isLeapYear(year)) 29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }



}