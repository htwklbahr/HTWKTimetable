package com.lb.shared.utils.calendar

import kotlinx.datetime.*

object LocalDateExt {

    // basic extension functions

    fun now(): LocalDate{
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    }

    fun today(): DateUtil {
        return now().mapToDate()
    }

    fun stringToLocalTime(timeString: String): LocalTimeUtil {
        val time = timeString.split(":")
        return LocalTimeUtil(time.first().toInt(), time.last().toInt())
    }

    fun calculateHours(start: String, end: String): Double {
        val startTime = stringToLocalTime(start)
        val endTime = stringToLocalTime(end)
        val startMinutes = startTime.hour * 60 + startTime.minute
        val endMinutes = endTime.hour * 60 + endTime.minute

        val minuteDifference = endMinutes - startMinutes

        return minuteDifference.toDouble() / 60.0
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
     * Extension function that maps a [LocalDate] to custom [DateUtil] class.
     */
    fun LocalDate.mapToDate() = DateUtil(
        day = this.dayOfMonth,
        month = YearMonth(this),
        year = year,
    )

    /**
     * Extension function that maps a [DateUtil] to custom [LocalDate] class.
     */
    fun DateUtil.mapToLocalDate() = LocalDate(
        year = year,
        monthNumber = month.monthNr,
        dayOfMonth = day,
    )

    fun isLeapYear(year: Int): Boolean {
        val prolepticYear: Long = year.toLong()
        return prolepticYear and 3 == 0L && (prolepticYear % 100 != 0L || prolepticYear % 400 == 0L)
    }

    /**
     * Function that gets the number of calender weeks of a year dependent on 1st Jan. and leap year.
     * @param [year]
     * @return 52 or 53
     */
    fun lastCalendarWeek(year: Int): Int {
        val firstDayOfYear = LocalDate(year, 1, 1)
        return if (isLeapYear(year)) {
            if (firstDayOfYear.dayOfWeek.isoDayNumber == 3 || firstDayOfYear.dayOfWeek.isoDayNumber == 4) 53
            else 52
        } else {
            if (firstDayOfYear.dayOfWeek.isoDayNumber == 4) 53
            else 52
        }
    }

    /**
     * Function that gets the current week.
     * @return [YearWeek]
     */
    fun getCurrentWeek(): YearWeek {
        return YearWeek.getByLocalDate(now())
    }

    /**
     * Function that gets a week by it's calendar week number and year.
     * @return [YearWeek]
     */
    fun getWeekByNr(calendarWeek: Int, year: Int): YearWeek {
        return when (calendarWeek) {
            0 -> YearWeek.getByCalendarWeek(lastCalendarWeek(year - 1), year - 1)
            53 -> {
                if (lastCalendarWeek(year) == 53)
                    YearWeek.getByCalendarWeek(calendarWeek, year)
                else YearWeek.getByCalendarWeek(1, year + 1)
            }

            else -> YearWeek.getByCalendarWeek(calendarWeek, year)
        }
    }
}

data class LocalTimeUtil(
    val hour: Int,
    val minute: Int
)