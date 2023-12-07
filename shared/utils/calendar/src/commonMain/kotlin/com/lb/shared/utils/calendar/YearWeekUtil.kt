package com.lb.shared.utils.calendar

import com.lb.shared.utils.calendar.LocalDateExt.isLeapYear
import com.lb.shared.utils.calendar.LocalDateExt.mapToDate
import com.lb.shared.utils.calendar.LocalDateExt.mapToLocalDate
import com.lb.shared.utils.calendar.LocalDateExt.now
import kotlinx.datetime.*

/**
 * Data class that defines a calendar week.
 * @property [year] year of the week
 * @property [calendarWeek] number of calendar week
 * @property [month] month the week is in
 * @property [days] list of days within the week
 */
data class YearWeek(
    val year: Int,
    val calendarWeek: Int,
    val month: YearMonth,
) {

    companion object {

        fun getByLocalDate(date: LocalDate) : YearWeek {
            return date.getCalenderWeek()
        }

        /**
         * Extension function that returns the calendar week of a [LocalDate].
         * @return [YearWeek] of the given [LocalDate]
         */
        fun LocalDate.getCalenderWeek(): YearWeek {
            val firstDay = firstDayOfFirstCalendarWeek(this.year)

            // check if date is in last week of previous year
            if (firstDay > this)
                return YearWeek(
                    year = this.year - 1,
                    calendarWeek = lastCalendarWeek(this.year - 1),
                    month = YearMonth(this.year - 1, 12)
                )

            val calendarWeek = firstDay.until(this, DateTimeUnit.WEEK) + 1

            // check if date is in first week of following year
            return if (calendarWeek > lastCalendarWeek(this.year))
                (YearWeek(
                    year = this.year + 1,
                    calendarWeek = 1,
                    month = YearMonth(this.year + 1, 1)
                ))
            else
                YearWeek(
                    year = this.year,
                    calendarWeek = calendarWeek,
                    month = YearMonth(this)
                )
        }

        /**
         * Function gets the first [LocalDate] of the first calendar week of a given [LocalDate.year].
         * @return first [LocalDate] in the first calendar week
         */
        fun firstDayOfFirstCalendarWeek(year: Int): LocalDate {
            val firstDayOfYear = LocalDate(year, 1, 1)
            var firstDayOfWeek = firstDayOfYear.firstDayOfWeek()
            when {
                firstDayOfWeek.year < year && firstDayOfYear.dayOfWeek.isoDayNumber > DayOfWeek.THURSDAY.isoDayNumber -> {
                    firstDayOfWeek = firstDayOfWeek.plus(DatePeriod(days = 7))
                    return firstDayOfWeek
                }

                else -> return firstDayOfWeek
            }
        }

        /**
         * Function that gets the number of calender weeks of a year dependent on 1st Jan. and leap year.
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
         * Extension function that gets the first day of the week the date is in.
         * @return first day of week
         */
        fun LocalDate.firstDayOfWeek(): LocalDate {
            return this.minus(this.dayOfWeek.isoDayNumber - 1, DateTimeUnit.DAY)
        }

        /**
         * Extension function that returns the days of the week the date is in.
         * @return days of the week as list
         */
        fun LocalDate.getDaysOfWeekOfDate(): List<Date> {
            val firstDay = this.minus(this.dayOfWeek.isoDayNumber - 1, DateTimeUnit.DAY)
            val weekDays = mutableListOf(firstDay.mapToDate())
            for (i in 1..6) {
                weekDays.add(firstDay.plus(DatePeriod(days = i)).mapToDate())
            }
            return weekDays
        }
    }


}

