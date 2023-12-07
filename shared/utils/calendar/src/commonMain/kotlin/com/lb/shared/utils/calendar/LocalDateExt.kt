package com.lb.shared.utils.calendar

import kotlinx.datetime.*

object LocalDateExt {

    // basic extension functions

    fun now(): LocalDate{
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    }

    fun formatDate(): String {
        return now().toString()
    }

    /**
     * Extension function that gets the first day of the week the date is in.
     * @return first day of week
     */
    fun LocalDate.firstDayOfWeek(): LocalDate {
        return this.minus(this.dayOfWeek.isoDayNumber - 1, DateTimeUnit.DAY)
    }

    /**
     * Extension function that maps a [LocalDate] to custom [Date] class.
     */
    fun LocalDate.mapToDate() = Date(
        day = this.dayOfMonth,
        month = YearMonth(this),
        year = year,
    )

    /**
     * Extension function that maps a [Date] to custom [LocalDate] class.
     */
    fun Date.mapToLocalDate() = LocalDate(
        year = year,
        monthNumber = month.monthNr,
        dayOfMonth = day,
    )

    fun isLeapYear(year: Int): Boolean {
        val prolepticYear: Long = year.toLong()
        return prolepticYear and 3 == 0L && (prolepticYear % 100 != 0L || prolepticYear % 400 == 0L)
    }



    /**
     * Function that gets the current week.
     * @return [YearWeek]
     */
    fun getCurrentWeek(): YearWeek {
        return YearWeek.getByLocalDate(LocalDate(2023, 1, 1))
    }

    fun getWeek1(): YearWeek {
        return YearWeek.getByLocalDate(LocalDate(2022, 12, 31))
    }

    fun getWeek2(): YearWeek {
        return YearWeek.getByLocalDate(LocalDate(2022, 12, 25))
    }

    fun getWeek3(): YearWeek {
        return YearWeek.getByLocalDate(LocalDate(2022, 12, 26))
    }

    fun getWeek4(): YearWeek {
        return YearWeek.getByLocalDate(LocalDate(2024, 2, 29))
    }

    fun getWeek5(): YearWeek {
        return YearWeek.getByLocalDate(LocalDate(2024, 12, 30))
    }

}

class LocalTimeUtil(
    val hour: Int,
    val minute: Int
)