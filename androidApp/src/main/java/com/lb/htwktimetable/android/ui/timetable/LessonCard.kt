package com.lb.htwktimetable.android.ui.timetable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.lb.functionalities.data.entities.LectureObjectDto

@Composable
fun LessonCard(
    lecture: LectureObjectDto,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Cyan)
    ) {
        Column(
            modifier = Modifier
                .padding(2.dp)
        ) {
            Text(
                text = lecture.module.substringAfter(" ", ""),
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = -0.05.sp,
                lineHeight = 11.sp,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = lecture.rooms,
                fontSize = 10.sp,
                letterSpacing = -0.5.sp,
                lineHeight = 11.sp
            )
        }
    }
}

@Preview
@Composable
private fun LessonPreview() {
    Surface {
        //LessonCard(modifier = Modifier.padding(16.dp))
    }
}