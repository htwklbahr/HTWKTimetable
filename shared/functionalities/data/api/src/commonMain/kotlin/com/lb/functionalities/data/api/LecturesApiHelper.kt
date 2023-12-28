package com.lb.functionalities.data.api

import com.lb.functionalities.data.api.model.*
import com.lb.functionalities.data.entities.LectureObjectDto

class LecturesApiHelper {

    fun getAllLectures(): List<LectureObjectDto> =
        LecturesApiService().getDummyLectureData().map { lectureObject ->
            lectureObject.toDto()
        }


}

interface ApiHelper {
    companion object {
        fun getApiAccess(): ApiHelper {
            return LecturesApiHelperImpl()
        }
    }
    suspend fun getPlaceholderData(): List<PlaceholderObject>
}