package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import com.lb.shared.utils.calendar.*

private val hours = buildList {
    for (i in 7..22) {
        if (i < 10) add("0$i:00")
        else add("$i:00")
    }
}

private val hourHeight = 44.dp

private val days = listOf(
    12, 13, 14, 15, 16, 17, 18
)

@Composable
fun TimetableContent() {
    Box(modifier = Modifier.wrapContentSize().verticalScroll(rememberScrollState())) {
        HourSlots()
        WekkdayColumns()
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
            Box(modifier = Modifier.height(44.dp)) {
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
private fun WekkdayColumns() {
    LazyRow(
        modifier = Modifier
            .padding(start = 48.dp)
            .fillMaxSize()
    ) {
        items(days) { day ->
            Row(
                modifier = Modifier
                    .fillParentMaxWidth(1 / 7f)
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(704.dp)
                        .background(Color.LightGray)
                )
                Lessons(day)
            }

        }
    }
}

private fun calculatePosition(startTime: LocalTimeUtil): Double {
    val hour = startTime.hour - 7
    val min = startTime.minute.toDouble() / 60
    return (hour + min)
}



@Composable
private fun Lessons(day: Int) {
    LessonCard(modifier = Modifier
        .padding(start = 2.dp, end = 2.dp, top = calculatePosition(LocalTimeUtil(13, 30)) * hourHeight + 8.dp)
        .height(1.5 * hourHeight)
    )
}