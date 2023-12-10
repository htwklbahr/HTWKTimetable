package com.lb.functionalities.data.api.dummydata

import com.lb.functionalities.data.api.model.LectureObject

/**
 * Class that defines dummy lectures.
 */
class DummyLectures{
    companion object {
        val lectures: List<LectureObject> = listOf(
            LectureObject(
                weekday = "Monday",
                weeks = listOf(49, 50, 57),
                start = "7:45",
                end = "9:15",
                module = "C247 Grundlagen Internet-basierter Informationssysteme IN-B & MI-B 5. FS (wpf)",
                type = "Vw",
                lecturer = "Prof. Dr. rer. nat.Thomas Riechert",
                rooms = "GU102-S",
                comment = "Projektpräsentationen",
                booked = "29.08.2023"
            )
        )
    }
}