package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
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
            TopBar()
            uiState.Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            TimetableContent()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TimetbleScreenPreview() {
    TimetableScreen()
}