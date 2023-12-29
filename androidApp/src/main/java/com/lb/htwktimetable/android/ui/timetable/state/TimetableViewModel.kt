package com.lb.htwktimetable.android.ui.timetable.state

import android.util.Log
import androidx.lifecycle.*
import com.lb.functionalities.data.database.LecturesDataSource
import com.lb.functionalities.data.entities.LectureObjectDto
import com.lb.shared.utils.calendar.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimetableViewModel @Inject constructor(
    private val lecturesDb: LecturesDataSource
) : ViewModel() {

    private val week: MutableStateFlow<YearWeek> = MutableStateFlow(LocalDateExt.getCurrentWeek())
    private val prevWeek: MutableStateFlow<YearWeek> =
        MutableStateFlow(LocalDateExt.getWeekByNr(week.value.calendarWeek - 1, week.value.year))
    private val nextWeek: MutableStateFlow<YearWeek> =
        MutableStateFlow(LocalDateExt.getWeekByNr(week.value.calendarWeek + 1, week.value.year))
    private val lectures: MutableStateFlow<List<LectureObjectDto>?> = MutableStateFlow(null)

    val uiState = combine(week, lectures, prevWeek, nextWeek) { week, lectures, prev, next ->
        TimetableState(
            week = week,
            prevWeek = prev,
            nextWeek = next,
            lectures = lectures,
            today = LocalDateExt.today()
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        TimetableState()
    )

    init {
        getData()
    }

    // Fetch lectures from database.
    fun getData() {
        viewModelScope.launch {
            val lastWeek = LocalDateExt.lastCalendarWeek(week.value.year)
            var weekNr = week.value.calendarWeek
            if (weekNr < 10)
                weekNr += lastWeek
            lectures.emit(lecturesDb.getLecturesByWeek(weekNr.toString()))
            Log.d("WEEKS", lectures.value.toString())
        }
    }

    // Functions for navigating between the weeks and fetching the lectures from the database.
    fun showNextWeek() {
        prevWeek.update { week.value }
        week.update { nextWeek.value }
        nextWeek.update { LocalDateExt.getWeekByNr(week.value.calendarWeek + 1, week.value.year) }
        getData()
    }

    fun showPreviousWeek() {
        nextWeek.update { week.value }
        week.update { prevWeek.value }
        prevWeek.update { LocalDateExt.getWeekByNr(week.value.calendarWeek - 1, week.value.year) }
        getData()
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
        getData()
    }
}