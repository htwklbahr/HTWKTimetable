package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.*
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

private val hours = buildList {
    for (i in 7..22) {
        if (i < 10) add("0$i:00")
        else add("$i:00")
    }
}

@Composable
fun TimetableScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TopBar()
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            TimetableContent()
        }
    }
}

@Composable
fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
    ) {
        Text(text = "November 2023", fontSize = 18.sp)
    }
}

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
fun HeaderItem(
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

@Composable
fun TimetableContent() {

        Row(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(48.dp)
            ) {
                repeat(hours.size) { hour ->
                    Box(
                        modifier = Modifier
                            .height(44.dp)
                    ) {
                        Text(
                            text = hours[hour],
                            fontSize = 12.sp
                        )
                    }
                }
            }
            LazyRow(modifier = Modifier.fillMaxSize()) {
                items(7) { _ ->
                    Column(
                        modifier = Modifier
                            .fillParentMaxWidth(1 / 7f)
                            .fillMaxHeight()
                            .padding(top = 9.dp)
                    ) {
                        repeat(15) {
                            Spacer(modifier = Modifier.height(43.dp))
                            Divider(modifier = Modifier.height(1.dp))
                        }
                    }
                }
            }
        }


}

@Preview(showSystemUi = true)
@Composable
fun TimetbleScreenPreview() {
    TimetableScreen()
}