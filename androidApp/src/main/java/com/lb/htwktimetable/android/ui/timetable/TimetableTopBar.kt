package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.lb.htwktimetable.android.ui.timetable.state.TimetableState
import com.lb.shared.utils.calendar.LocalDateExt

@Composable
fun TimetableState.TopBar(
    nextWeek: () -> Unit,
    previousWeek: () -> Unit,
    currentWeek: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier
                .clickable { previousWeek() }
                .padding(8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentSize()
        ) {
            Text(
                text = "${week?.days?.first()?.month?.name} ${week?.days?.first()?.year}",
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Outlined.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .clickable { currentWeek() }
                    .padding(start = 8.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier
                .clickable { nextWeek() }
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    Surface {
        TimetableState(week = LocalDateExt.getCurrentWeek()).TopBar({}, {}, {})
    }
}