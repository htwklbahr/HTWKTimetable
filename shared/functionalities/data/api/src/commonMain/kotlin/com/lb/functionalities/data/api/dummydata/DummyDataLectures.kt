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
            LectureObject(
                weekday = "Montag",
                weeks = listOf(42, 43, 45, 46, 47, 48, 49, 50, 51, 54, 55, 56, 57),
                start = "17:15",
                end = "18:45",
                module = "C340 Projektmanagementpraktikum INM 3.& 5. FS (pf) & C453 Softwareprojekt Teil II INB und MIB 5.FS (pf)",
                type = "Pp",
                lecturer = "Prof. Dr. rer. nat. Karsten Weicker",
                rooms = "ZU423-L",
                comment = "",
                booked = "22.08.2023"
            ),
            // Tuesday
            LectureObject(
                weekday = "Dienstag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "11:15",
                end = "12:45",
                module = "C182 Computeranimation IN-B & MI-B 5.FS (wpf)",
                type = "Vw",
                lecturer = "Prof. Dr. Kiran Varanasi",
                rooms = "TR_A1.24-H",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Dienstag",
                weeks = listOf(42, 46, 48, 50, 54, 56),
                start = "7:30",
                end = "9:00",
                module = "C182 Computeranimation IN-B & MI-B 5.FS (wpf)",
                type = "Vw",
                lecturer = "Prof. Dr. Kiran Varanasi",
                rooms = "LI203-S",
                comment = "",
                booked = "11.09.2023"
            ),
            LectureObject(
                weekday = "Dienstag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "13:45",
                end = "15:15",
                module = "C763 Digitale Signal- und Bildverarbeitung INB (wpf) & MIB 5.FS (pf)",
                type = "V",
                lecturer = "Prof. Dr. rer. nat. Mario Hlawitschka",
                rooms = "LI309-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Dienstag",
                weeks = listOf(42, 46, 48, 50, 54, 56),
                start = "13:45",
                end = "15:15",
                module = "C763 Digitale Signal- und Bildverarbeitung INB (wpf) & MIB 5.FS (pf)",
                type = "V",
                lecturer = "Prof. Dr. rer. nat. Mario Hlawitschka",
                rooms = "LI309-S",
                comment = "",
                booked = "29.08.2023"
            ),
            // Wednesday
            LectureObject(
                weekday = "Mittwoch",
                weeks = listOf(42, 44, 46, 48, 50, 54, 56),
                start = "7:45",
                end = "9:15",
                module = "C763 Digitale Signal- und Bildverarbeitung INB (wpf) & MIB 5.FS (pf)",
                type = "Sp",
                lecturer = "Prof. Dr. rer. nat. Mario Hlawitschka",
                rooms = "LI210-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Mittwoch",
                weeks = listOf(42, 44, 46, 48, 50, 54, 56),
                start = "11:15",
                end = "12:45",
                module = "C182 Computeranimation IN-B & MI-B 5.FS (wpf)",
                type = "Sw",
                lecturer = "Nico Laube",
                rooms = "ZU229-L",
                comment = "",
                booked = "11.09.2023"
            ),
            LectureObject(
                weekday = "Mittwoch",
                weeks = listOf(45, 50),
                start = "17:15",
                end = "20:30",
                module = "W233 Einführung in die Betriebswirtschaftslehre INB & MIB 5. FS (wpf)",
                type = "V",
                lecturer = "Dipl.-Kffr. Gisela Schwetzler",
                rooms = "GU110-S",
                comment = "Zusatzveranstaltungen",
                booked = "03.11.2023"
            ),
            LectureObject(
                weekday = "Mittwoch",
                weeks = listOf(42, 44, 46, 48, 50, 54, 56),
                start = "9:30",
                end = "11:00",
                module = "C757 Multimedia-Datenbanken MIB 5.FS (pf)",
                type = "Sp",
                lecturer = "Prof. Dr.-Ing. Robert Müller",
                rooms = "LI107-L",
                comment = "",
                booked = "30.08.2023"
            ),
            LectureObject(
                weekday = "Mittwoch",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "11:15",
                end = "12:45",
                module = "C757 Multimedia-Datenbanken MIB 5.FS (pf)",
                type = "Sp",
                lecturer = "Prof. Dr.-Ing. Robert Müller",
                rooms = "LI107-L",
                comment = "",
                booked = "30.08.2023"
            ),
            // Thursday
            LectureObject(
                weekday = "Donnerstag",
                weeks = listOf(42, 44, 48, 50, 54, 56, 58),
                start = "13:45",
                end = "17:00",
                module = "W233 Einführung in die Betriebswirtschaftslehre INB & MIB 5. FS (wpf)",
                type = "V",
                lecturer = "Dipl.-Kffr. Gisela Schwetzler",
                rooms = "TR_A1.29-H",
                comment = "",
                booked = "05.10.2023"
            ),
            LectureObject(
                weekday = "Donnerstag",
                weeks = listOf(45, 49, 51, 55, 57),
                start = "13:45",
                end = "17:00",
                module = "W233 Einführung in die Betriebswirtschaftslehre INB & MIB 5. FS (wpf)",
                type = "Sw",
                lecturer = "Dipl.-Kffr. Gisela Schwetzler",
                rooms = "TGU114-S",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Donnerstag",
                weeks = listOf(42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 54, 55, 56, 57),
                start = "7:30",
                end = "9:00",
                module = "C340 Projektmanagementpraktikum INM 3.& 5. FS (pf) & C453 Softwareprojekt Teil II INB und MIB 5.FS (pf)",
                type = "Pp",
                lecturer = "Prof. Dr. rer. nat. Karsten Weicker",
                rooms = "ZU423-L",
                comment = "",
                booked = "14.11.2023"
            ),
            // Friday
            LectureObject(
                weekday = "Freitag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "15:30",
                end = "17:00",
                module = "C182 Computeranimation IN-B & MI-B 5.FS (wpf)",
                type = "Sw",
                lecturer = "Nico Laube",
                rooms = "ZU229-L",
                comment = "",
                booked = "14.09.2023"
            ),
            LectureObject(
                weekday = "Freitag",
                weeks = listOf(42, 44, 46, 48, 50, 54, 56),
                start = "13:45",
                end = "15:15",
                module = "C247 Grundlagen Internet-basierter Informationssysteme IN-B & MI-B 5. FS (wpf)",
                type = "Sw",
                lecturer = "Prof. Dr. rer. nat.Thomas Riechert",
                rooms = "ZU423-L",
                comment = "",
                booked = "29.08.2023"
            ),
            LectureObject(
                weekday = "Freitag",
                weeks = listOf(43, 45, 47, 49, 51, 55, 57),
                start = "13:45",
                end = "15:15",
                module = "C247 Grundlagen Internet-basierter Informationssysteme IN-B & MI-B 5. FS (wpf)",
                type = "Sw",
                lecturer = "Prof. Dr. rer. nat.Thomas Riechert",
                rooms = "ZU423-L",
                comment = "",
                booked = "29.08.2023"
            ),
        )
    }
}