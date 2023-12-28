package com.lb.functionalities.data.database

import com.lb.functionalities.data.api.*
import com.lb.functionalities.data.api.model.PlaceholderObject
import com.lb.functionalities.data.entities.LectureObjectDto

class SqlDelightDataSource(database: LecturesDatabase) : LecturesDataSource {
    private val queries = database.lecturesQueries
    private val api = LecturesApiHelper()

    override suspend fun insertLectures(lectures: List<LectureObjectDto>) {
        queries.transaction {
            lectures.forEach { lecture ->
                insertLecture(lecture)
            }
        }
    }

    override suspend fun getAllLectures(): List<LectureObjectDto> {
        return queries.getAllLectures(::mapToLecture).executeAsList()
    }

    override suspend fun fetchLectures(): List<LectureObjectDto> {
        return api.getAllLectures().also {
            clearDatabase()
            insertLectures(it)
        }
    }

    override suspend fun getLecturesByWeek(week: String): List<LectureObjectDto> {
        fetchLectures()
        return queries.getLecturesByWeek(week, ::mapToLecture).executeAsList()
    }

    override suspend fun clearDatabase() {
        queries.deleteAllLectures()
    }

    override suspend fun getPlaceholderData(): List<PlaceholderObject> {
        return ApiHelper.getApiAccess().getPlaceholderData()
    }

    private fun insertLecture(lecture: LectureObjectDto) {
        queries.insertLecture(
            weekday = lecture.weekday,
            weeks = lecture.weeks,
            start = lecture.start,
            end = lecture.end,
            module = lecture.module,
            type = lecture.type,
            lecturer = lecture.lecturer,
            rooms = lecture.rooms,
            comment = lecture.comment,
            booked = lecture.booked
        )
    }

    private fun mapToLecture(
        id: Long,
        weekday: String,
        weeks: String,
        start: String,
        end: String,
        module: String,
        type: String,
        lecturer: String?,
        rooms: String?,
        comment: String?,
        booked: String?,
    ): LectureObjectDto {
        return LectureObjectDto(
            weekday = weekday,
            weeks = weeks,
            start = start,
            end = end,
            module = module,
            type = type,
            lecturer = lecturer ?: "",
            rooms = rooms ?: "",
            comment = comment ?: "",
            booked = booked ?: ""
        )
    }

}