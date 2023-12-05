package com.lb.shared.utils.calendar

import kotlinx.datetime.*

object LocalDateExt {

    // basic extension functions

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
}

class LocalTimeUtil(
    val hour: Int,
    val minute: Int
)