import Foundation
import shared

/*
 State that gathers displayed timetable data.
 */
struct TimetableState {
    var week: YearWeek? = nil
    var prevWeek: YearWeek? = nil
    var nextWeek: YearWeek? = nil
    var weekDays: [String] = [
        "Montag",
        "Dienstag",
        "Mittwoch",
        "Donnerstag",
        "Freitag",
        "Samstag",
        "Sonntag"
    ]
    var lectures: [LectureObjectDto]? = nil
    var today: DateUtil? = nil
}
