package com.lb.functionalities.data.api.model

import kotlinx.serialization.*

@Serializable
data class PlaceholderObject(
    @SerialName("userId") val user: Int,
    @SerialName("id") val id: Int,
    @SerialName("title") val name: String,
)