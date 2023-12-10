package com.lb.htwktimetable.android.ui.timetable.state

import android.util.Log
import androidx.lifecycle.*
import com.lb.functionalities.data.api.LecturesApiHelper
import com.lb.shared.utils.calendar.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class TimetableViewModel() : ViewModel() {

    private val week: MutableStateFlow<YearWeek> = MutableStateFlow(LocalDateExt.getCurrentWeek())
    private val prevWeek: MutableStateFlow<YearWeek> =
        MutableStateFlow(LocalDateExt.getWeekByNr(week.value.calendarWeek - 1, week.value.year))
    private val nextWeek: MutableStateFlow<YearWeek> =
        MutableStateFlow(LocalDateExt.getWeekByNr(week.value.calendarWeek + 1, week.value.year))
    private val lecture: MutableStateFlow<Nothing?> = MutableStateFlow(null)

    val uiState = combine(week, lecture, prevWeek, nextWeek) { week, _, prev, next ->
        TimetableState(
            week = week,
            prevWeek = prev,
            nextWeek = next
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        TimetableState()
    )

    fun showNextWeek() {
        prevWeek.update { week.value }
        week.update { nextWeek.value }
        nextWeek.update { LocalDateExt.getWeekByNr(week.value.calendarWeek + 1, week.value.year) }
    }

    fun showPreviousWeek() {
        nextWeek.update { week.value }
        week.update { prevWeek.value }
        prevWeek.update { LocalDateExt.getWeekByNr(week.value.calendarWeek - 1, week.value.year) }
    }

    fun showCurrentWeek() {
        week.update { LocalDateExt.getCurrentWeek() }
        prevWeek.update {
            LocalDateExt.getWeekByNr(
                week.value.calendarWeek - 1,
                week.value.year
            )
        }
        nextWeek.update {
            LocalDateExt.getWeekByNr(
                week.value.calendarWeek + 1,
                week.value.year
            )
        }
    }

    init {
        get()
    }


    fun get() {
        viewModelScope.launch {
            Log.d("WEEKS", LecturesApiHelper().getAllLectures().toString())
        }
    }
}