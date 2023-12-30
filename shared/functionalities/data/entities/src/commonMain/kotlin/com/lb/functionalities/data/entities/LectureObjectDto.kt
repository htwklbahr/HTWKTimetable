package com.lb.functionalities.data.entities

/**
 * Data class for using the lecture data everywhere needed.
 */
data class LectureObjectDto(
    val weekday: String,
    val weeks: String,
    val start: String,
    val end: String,
    val module: String,
    val type: String,
    val lecturer: String,
    val rooms: String,
    val comment: String,
    val booked: String,
)
