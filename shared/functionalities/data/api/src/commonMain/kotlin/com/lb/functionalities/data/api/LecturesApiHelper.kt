package com.lb.functionalities.data.api

import com.lb.functionalities.data.api.model.*
import com.lb.functionalities.data.entities.LectureObjectDto

/**
 * Helper class setting the functions for receiving the data.
 */
class LecturesApiHelper {

    fun getAllLectures(): List<LectureObjectDto> =
        LecturesApiService().getDummyLectureData().map { lectureObject ->
            lectureObject.toDto()
        }
}

// Different approach for accessing the API. Currently not used.
interface ApiHelper {
    companion object {
        fun getApiAccess(): ApiHelper {
            return LecturesApiHelperImpl()
        }
    }
    suspend fun getPlaceholderData(): List<PlaceholderObject>
}