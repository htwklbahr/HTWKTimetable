package com.lb.shared.utils.calendar

import com.lb.shared.utils.calendar.LocalDateExt.isLeapYear
import com.lb.shared.utils.calendar.LocalDateExt.mapToDate
import kotlinx.datetime.*

/**
 * Data class that defines a calendar week.
 * @property [year] year of the week
 * @property [calendarWeek] number of calendar week
 * @property [days] list of days within the week
 */
data class YearWeek(
    val year: Int,
    val calendarWeek: Int,
    val days: List<Date>
) {
    /**
     * Companion object to initialize [YearWeek] and it's properties.
     */
    companion object {

        /**
         * Internal function that creates an instance of [YearWeek] of a [LocalDate].
         * @param [date] [LocalDate] within the week
         * @return [YearWeek] the [date] is in
         */
        internal fun getByLocalDate(date: LocalDate) : YearWeek {
            return date.getCalenderWeek()
        }

        /**
         * Internal function that creates an instance of [YearWeek] of a [LocalDate].
         * @param [weekNr] calendar week number
         * @param [year] year the week is in
         * @return [YearWeek] of the given calendar week
         */
        internal fun getByCalendarWeek(weekNr: Int, year: Int) : YearWeek {
            val firstOfFirstWeek = firstDayOfFirstCalendarWeek(year)
            val firstOfWeek = firstOfFirstWeek.plus(weekNr - 1, DateTimeUnit.WEEK)
            return YearWeek(
                year = year,
                calendarWeek = weekNr,
                days = firstOfWeek.getDaysOfWeekOfDate()
            )
        }

        /**
         * Extension function that returns the calendar week of a [LocalDate].
         * @return [YearWeek] of the given [LocalDate]
         */
        private fun LocalDate.getCalenderWeek(): YearWeek {
            val firstOfFirstWeek = firstDayOfFirstCalendarWeek(this.year)

            // check if date is in last week of previous year
            if (firstOfFirstWeek > this)
                return YearWeek(
                    year = this.year - 1,
                    calendarWeek = lastCalendarWeek(this.year - 1),
                    days = this.getDaysOfWeekOfDate()
                )

            val calendarWeek = firstOfFirstWeek.until(this, DateTimeUnit.WEEK) + 1

            // check if date is in first week of following year
            return if (calendarWeek > lastCalendarWeek(this.year))
                (YearWeek(
                    year = this.year + 1,
                    calendarWeek = 1,
                    days = this.getDaysOfWeekOfDate()
                ))
            else
                YearWeek(
                    year = this.year,
                    calendarWeek = calendarWeek,
                    days = this.getDaysOfWeekOfDate()
                )
        }

        /**
         * Function gets the first [LocalDate] of the first calendar week of a given [LocalDate.year].
         * @param [year]
         * @return first [LocalDate] in the first calendar week
         */
        private fun firstDayOfFirstCalendarWeek(year: Int): LocalDate {
            val firstOfJan = LocalDate(year, 1, 1)
            var firstDayOfWeek = firstOfJan.firstDayOfWeek()
            return when {
                firstDayOfWeek.year < year && firstOfJan.dayOfWeek.isoDayNumber > DayOfWeek.THURSDAY.isoDayNumber -> {
                    firstDayOfWeek = firstDayOfWeek.plus(DatePeriod(days = 7))
                    firstDayOfWeek
                }

                else -> firstDayOfWeek
            }
        }

        /**
         * Function that gets the number of calender weeks of a year dependent on 1st Jan. and leap year.
         * @param [year]
         * @return 52 or 53
         */
        private fun lastCalendarWeek(year: Int): Int {
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
         * Extension function that returns the days of the week the date is in.
         * @return days of the week as list
         */
        private fun LocalDate.getDaysOfWeekOfDate(): List<Date> {
            val firstDay = this.firstDayOfWeek()
            val weekDays = mutableListOf(firstDay.mapToDate())
            for (i in 1..6) {
                weekDays.add(firstDay.plus(DatePeriod(days = i)).mapToDate())
            }
            return weekDays
        }

        /**
         * Extension function that gets the first day of the week the date is in.
         * @return first day of week as [LocalDate]
         */
        private fun LocalDate.firstDayOfWeek(): LocalDate {
            return this.minus(this.dayOfWeek.isoDayNumber - 1, DateTimeUnit.DAY)
        }
    }


}

