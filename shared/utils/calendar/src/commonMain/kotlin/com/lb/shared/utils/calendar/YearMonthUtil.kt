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

    val name = when (monthNr) {
        1 -> "Januar"
        2 -> "Februar"
        3 -> "März"
        4 -> "April"
        5 -> "Mai"
        6 -> "Juni"
        7 -> "Juli"
        8 -> "August"
        9 -> "September"
        10 -> "Oktober"
        11 -> "November"
        12 -> "Dezember"
        else -> ""
    }

    val numberOfDays = when (this.monthNr) {
        2 -> if (isLeapYear(year)) 29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }



}