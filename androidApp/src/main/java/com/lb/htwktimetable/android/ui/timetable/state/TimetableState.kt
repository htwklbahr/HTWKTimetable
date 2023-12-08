package com.lb.htwktimetable.android.ui.timetable.state

import com.lb.shared.utils.calendar.YearWeek

data class TimetableState(
    val week: YearWeek? = null,
    val prevWeek: YearWeek? = null,
    val nextWeek: YearWeek? = null,
    val weekDays: List<String> = listOf(
        "Montag",
        "Dienstag",
        "Mittwoch",
        "Donnerstag",
        "Freitag",
        "Samstag",
        "Sonntag"
    ),
)