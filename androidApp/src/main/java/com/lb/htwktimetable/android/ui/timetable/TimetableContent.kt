package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import com.lb.htwktimetable.android.ui.timetable.state.TimetableState
import com.lb.shared.utils.calendar.*

private val hours = buildList {
    for (i in 7..22) {
        if (i < 10) add("0$i:00")
        else add("$i:00")
    }
}

private val hourHeight = 64.dp

private fun calculatePosition(startTime: LocalTimeUtil): Double {
    val hour = startTime.hour - 7
    val min = startTime.minute.toDouble() / 60
    return (hour + min)
}

@Composable
fun TimetableState.TimetableContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        )
        Box(modifier = Modifier.wrapContentSize().verticalScroll(rememberScrollState())) {
            HourSlots()
            WekkdayColumns()
        }
    }
}

@Composable
private fun HourSlots() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        repeat(hours.size) { hour ->
            Box(modifier = Modifier.height(hourHeight)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.width(48.dp)
                    ) {
                        Text(
                            text = hours[hour],
                            fontSize = 12.sp
                        )
                    }
                    Divider(modifier = Modifier.height(1.dp))
                }
            }
        }
    }
}

@Composable
private fun TimetableState.WekkdayColumns() {
    LazyRow(
        modifier = Modifier
            .padding(start = 48.dp)
            .fillMaxSize()
    ) {
        items(weekDays) { day ->
            Row(
                modifier = Modifier
                    .fillParentMaxWidth(1 / 7f)
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(hourHeight * 16)
                        .background(Color.LightGray)
                )
                Box {
                    lectures?.forEach {
                        if (it.weeks.contains(week?.calendarWeek.toString()) && it.weekday == day) {
                            LessonCard(
                                lecture = it,
                                modifier = Modifier
                                    .padding(top = calculatePosition(LocalDateExt.stringToLocalTime(it.start)) * hourHeight + 8.dp)
                                    .height(LocalDateExt.calculateHours(it.start, it.end) * hourHeight)
                            )
                        }
                    }
                }
            }
        }
    }
}