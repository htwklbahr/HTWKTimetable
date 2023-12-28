package com.lb.functionalities.data.api.dummydata

import com.lb.functionalities.data.api.model.LectureObject

/**
 * Class that defines dummy lectures.
 */
class DummyLectures{
    companion object {
        val lectures: List<LectureObject> = listOf(
            LectureObject(
                weekday = "Montag",
                weeks = listOf(42, 46, 48, 50, 54, 56),
                start = "7:45",
                end = "9:15",
                module = "C247 Grundlagen Internet-basierter Informationssysteme IN-B & MI-B 5. FS (wpf)",
                type = "Vw",
                lecturer = "Prof. Dr. rer. nat.Thomas Riechert",
                rooms = "GU102-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Montag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "7:45",
                end = "9:15",
                module = "C247 Grundlagen Internet-basierter Informationssysteme IN-B & MI-B 5. FS (wpf)",
                type = "Vw",
                lecturer = "Prof. Dr. rer. nat.Thomas Riechert",
                rooms = "GU102-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Montag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "11:15",
                end = "12:45",
                module = "C763 Digitale Signal- und Bildverarbeitung INB (wpf) & MIB 5.FS (pf)",
                type = "V",
                lecturer = "Prof. Dr. rer. nat. Mario Hlawitschka",
                rooms = "LI310-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Montag",
                weeks = listOf(42, 46, 48, 50, 54, 56),
                start = "13:45",
                end = "15:15",
                module = "C757 Multimedia-Datenbanken MIB 5.FS (pf)",
                type = "Vp",
                lecturer = "Prof. Dr.-Ing. Robert Müller",
                rooms = "NI003-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Montag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "13:45",
                end = "15:15",
                module = "C757 Multimedia-Datenbanken MIB 5.FS (pf)",
                type = "Vp",
                lecturer = "Prof. Dr.-Ing. Robert Müller",
                rooms = "LI211-S",
                comment = "",
                booked = "29.08.2023"
            ),
            // Tuesday
            LectureObject(
                weekday = "Dienstag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "11:15",
                end = "12:45",
                module = "C182 Computeranimation IN-B & MI-B 5.FS (wpf)",
                type = "Sp",
                lecturer = "Prof. Dr. Kiran Varanasi",
                rooms = "TR_A1.24-H",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Donnerstag",
                weeks = listOf(42, 44, 48, 50, 54, 56),
                start = "13:45",
                end = "17:00",
                module = "W233 Einführung in die Betriebswirtschaftslehre INB & MIB 5. FS (wpf)",
                type = "V",
                lecturer = "Dipl.-Kffr. Gisela Schwetzler",
                rooms = "TR_A1.29-H",
                comment = "",
                booked = "5.10.2023"
            ),
        )
    }
}