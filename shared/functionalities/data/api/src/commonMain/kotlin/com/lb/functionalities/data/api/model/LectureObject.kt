package com.lb.functionalities.data.api.model

import com.lb.functionalities.data.entities.LectureObjectDto
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
    @SerialName("rooms") val rooms: String,
    @SerialName("comment") val comment: String,
    @SerialName("booked") val booked: String,
)

internal fun LectureObject.toDto(): LectureObjectDto =
    LectureObjectDto(
        weekday = weekday,
        weeks = weeks,
        start = start,
        end = end,
        module = module,
        type = type,
        lecturer = lecturer,
        rooms = rooms,
        comment = comment,
        booked = booked
    )

