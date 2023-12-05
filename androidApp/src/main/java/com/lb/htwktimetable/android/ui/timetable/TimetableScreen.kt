package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*



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


/*@Composable
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
            items(days) { day ->
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
}*/



@Preview(showSystemUi = true)
@Composable
fun TimetbleScreenPreview() {
    TimetableScreen()
}