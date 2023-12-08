package com.lb.htwktimetable.android.ui.timetable.state

import androidx.lifecycle.*
import com.lb.shared.utils.calendar.*
import kotlinx.coroutines.flow.*


class TimetableViewModel() : ViewModel() {

    private val week: StateFlow<YearWeek> = MutableStateFlow(LocalDateExt.getCurrentWeek())
    private val lecture: MutableStateFlow<Nothing?> = MutableStateFlow(null)

    val uiState = combine(week, lecture) { week, _ ->
        TimetableState(
            week = week,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        TimetableState()
    )
}