package com.lb.functionalities.data.database

import com.lb.functionalities.data.api.model.PlaceholderObject
import com.lb.functionalities.data.entities.LectureObjectDto

interface LecturesDataSource {
    suspend fun insertLectures(lectures: List<LectureObjectDto>)

    suspend fun getAllLectures(): List<LectureObjectDto>

    @Throws(Exception::class)
    suspend fun fetchLectures(): List<LectureObjectDto>

    suspend fun clearDatabase()

    suspend fun getPlaceholderData(): List<PlaceholderObject>

}