//package com.lb.functionalities.data.database
//
//import com.lb.functionalities.data.api.LecturesApiHelper
//import com.lb.functionalities.data.entities.LectureObjectDto
//
//internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
//    private val database = LecturesDatabase(databaseDriverFactory.createDriver())
//    private val dbQuery = database.lecturesQueries
//
//    internal fun getAllLectures(): List<LectureObjectDto> {
//        return dbQuery.getAllLectures(::mapToLecture).executeAsList()
//    }
//
//    fun createLectures(lectures: List<LectureObjectDto>) {
//        dbQuery.transaction {
//            lectures.forEach { lecture ->
//                insertLecture(lecture)
//            }
//        }
//    }
//
//    private fun mapToLecture(
//        id: Long,
//        weekday: String,
//        weeks: String,
//        start: String,
//        end: String,
//        module: String,
//        type: String,
//        lecturer: String?,
//        rooms: String?,
//        comment: String?,
//        booked: String?,
//    ): LectureObjectDto {
//        return LectureObjectDto(
//            weekday = weekday,
//            weeks = listOf(2) ,
//            start = start,
//            end = end,
//            module = module,
//            type = type,
//            lecturer = lecturer ?: "",
//            rooms = rooms ?: "",
//            comment = comment ?: "",
//            booked = booked ?: ""
//        )
//    }
//
//    private fun insertLecture(lecture: LectureObjectDto) {
//        dbQuery.insertLecture(
//            weekday = lecture.weekday,
//            weeks = lecture.weeks.toString(),
//            start = lecture.start,
//            end = lecture.end,
//            module = lecture.module,
//            type = lecture.type,
//            lecturer = lecture.lecturer,
//            rooms = lecture.rooms,
//            comment = lecture.comment,
//            booked = lecture.booked
//        )
//    }
//
//
//    internal fun clearDatabase() {
//        dbQuery.deleteAllLectures()
//    }
//
//}
//
//class LectureDB(databaseDriverFactory: DatabaseDriverFactory) {
//    private val database = Database(databaseDriverFactory)
//    private val api = LecturesApiHelper()
//
//    @Throws(Exception::class)
//    suspend fun getLectures(): List<LectureObjectDto> {
//        return api.getAllLectures().also {
//            database.clearDatabase()
//            database.createLectures(it)
//        }
//    }
//}
