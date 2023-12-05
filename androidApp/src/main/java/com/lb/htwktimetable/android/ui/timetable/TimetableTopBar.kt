package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

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