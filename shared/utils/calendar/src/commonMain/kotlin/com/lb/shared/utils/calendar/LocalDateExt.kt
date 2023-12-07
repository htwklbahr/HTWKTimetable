package com.lb.shared.utils.calendar

import kotlinx.datetime.*

object LocalDateExt {

    // basic extension functions

    fun now(): LocalDate{
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    }

    fun LocalDateTime.Companion.now(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }

    fun LocalDate.Companion.now(): LocalDate {
        return LocalDateTime.now().date
    }

    fun LocalTime.Companion.now(): LocalTime {
        return LocalDateTime.now().time
    }

    fun formatDate(): String {
        return LocalDateTime.now().toString()
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
    fun LocalDate.getDaysOfWeek(): List<LocalDate> {
        val firstDay = this.minus(this.dayOfWeek.isoDayNumber - 1, DateTimeUnit.DAY)
        val week = mutableListOf(firstDay)
        for (i in 1..6) {
            week.add(firstDay.plus(DatePeriod(days = i)))
        }
        return week
    }

    fun getWeek(): YearWeek {
        val days = mutableListOf<Int>()
        now().getDaysOfWeek().forEach {
            days.add(it.dayOfMonth)
        }
        return (YearWeek(now().monthNumber, days))
    }

}

class YearWeek(
    val month: Int,
    val days: List<Int>
)

class LocalTimeUtil(
    val hour: Int,
    val minute: Int
)