package com.lb.functionalities.data.api

import com.lb.functionalities.data.api.model.toDto
import com.lb.functionalities.data.entities.LectureObjectDto

class LecturesApiHelper() {

    fun getAllLectures(): List<LectureObjectDto> =
        LecturesApiService().getDummyLectureData().map { lectureObject ->
            lectureObject.toDto()
        }
}