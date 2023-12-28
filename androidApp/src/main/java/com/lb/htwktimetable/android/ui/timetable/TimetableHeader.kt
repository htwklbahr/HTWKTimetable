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
import com.lb.htwktimetable.android.ui.timetable.state.TimetableState
import com.lb.shared.utils.calendar.DateUtil

@Composable
fun TimetableState.Header(
    modifier: Modifier = Modifier,

) {
    Row(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.width(48.dp)
        ) {
            Text("KW", fontWeight = FontWeight.Bold)
            Text(week?.calendarWeek.toString(), fontWeight = FontWeight.Bold)
        }
        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            items(weekDays) { day ->
                HeaderItem(
                    day = day,
                    date = week?.days?.get(weekDays.indexOf(day)),
                    modifier = Modifier.fillParentMaxWidth(1 / 7f)
                )
            }
        }
    }
}

@Composable
private fun TimetableState.HeaderItem(
    day: String,
    date: DateUtil?,
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
                    color = if (date == today) Color(0xFF98FB98) else Color.LightGray,
                    shape = CircleShape
                )
                .size(36.dp)
        ) {
            Text(text = day.take(2), fontSize = 12.sp)
            Text(
                text = date?.day.toString(),
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
        //Header(modifier = Modifier.padding(16.dp))
    }
}