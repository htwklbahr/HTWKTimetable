package com.lb.functionalities.data.api.model

import kotlinx.serialization.*

/**
 * Data class for serializing the lectures received from the API.
 */
@Serializable
data class LectureObject(
    @SerialName("weekday") val weekday: String,
    @SerialName("weeks") val weeks: List<Int>,
    @SerialName("start") val start: String,
    @SerialName("end") val end: String,
    @SerialName("module") val module: String,
    @SerialName("type") val type: String,
    @SerialName("lecturer") val lecturer: String,
    @SerialName("room") val room: String,
    @SerialName("comment") val comment: String,
    @SerialName("booked") val booked: String,
)
