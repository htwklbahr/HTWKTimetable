package com.lb.functionalities.data.entities

data class LectureObjectDto(
    val weekday: String,
    val weeks: List<Int>,
    val start: String,
    val end: String,
    val module: String,
    val type: String,
    val lecturer: String,
    val rooms: String,
    val comment: String,
    val booked: String,
)
