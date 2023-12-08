package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lb.htwktimetable.android.ui.timetable.state.TimetableViewModel

@Composable
fun TimetableScreen(
    viewModel: TimetableViewModel = TimetableViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            uiState.TopBar(
                nextWeek = { viewModel.showNextWeek() },
                previousWeek = { viewModel.showPreviousWeek() },
                currentWeek = { viewModel.showCurrentWeek() }
            )
            uiState.TimetableContent()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TimetbleScreenPreview() {
    TimetableScreen()
}