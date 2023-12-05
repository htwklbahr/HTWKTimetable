package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

private val weekDays = listOf(
    "Montag",
    "Dienstag",
    "Mittwoch",
    "Donnerstag",
    "Freitag",
    "Samstag",
    "Sonntag"
)

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.width(48.dp)
        ) {
            Text("KW", fontWeight = FontWeight.Bold)
            Text("48", fontWeight = FontWeight.Bold)
        }
        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            items(weekDays) { day ->
                HeaderItem(day, Modifier.fillParentMaxWidth(1 / 7f))
            }
        }
    }
}

@Composable
private fun HeaderItem(
    day: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .size(36.dp)
        ) {
            Text(text = day.take(2), fontSize = 12.sp)
            Text(
                text = "12",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Surface {
        Header(modifier = Modifier.padding(16.dp))
    }
}