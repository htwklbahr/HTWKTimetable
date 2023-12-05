package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LessonCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.Cyan)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text("Kommunikations- und Medienwissenschaftliches Arbeiten")
            Text("Li401")
        }
    }
}

@Preview
@Composable
private fun LessonPreview() {
    Surface {
        LessonCard(modifier = Modifier.padding(16.dp))
    }
}