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
        return YearWeek.getByLocalDate(LocalDate(2023, 12, 31))
    }

    /**
     * Function that gets a week by it's calendar week number and year.
     * @return [YearWeek]
     */
    fun getWeekByNr(): YearWeek {
        return YearWeek.getByCalendarWeek(52, 2023)
    }



}

class LocalTimeUtil(
    val hour: Int,
    val minute: Int
)