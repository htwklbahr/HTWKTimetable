import Foundation
import shared

extension TimetableScreen {
    
    @MainActor
    class TimetableViewModel: ObservableObject {
        private var lecturesDataSource: LecturesDataSource?
        
        @Published var timetableState = TimetableState()
                
        private var _week: YearWeek = LocalDateExt().getCurrentWeek()
        
        func fetchLectures() {
            let lastWeek = LocalDateExt().lastCalendarWeek(year: timetableState.week?.year ?? 0)
            var weekNr = timetableState.week?.calendarWeek ?? 0
            if weekNr < 10 {
                weekNr += lastWeek
            }
            self.lecturesDataSource?.getLecturesByWeek(week: String(weekNr), completionHandler: { lectures, error in
                self.timetableState.lectures = lectures ?? []
            })
        }
        
        func fetchData() {
            timetableState.week = _week
            timetableState.prevWeek = LocalDateExt().getWeekByNr(calendarWeek: _week.calendarWeek - 1, year: _week.year)
            timetableState.nextWeek = LocalDateExt().getWeekByNr(calendarWeek: _week.calendarWeek + 1, year: _week.year)
            timetableState.today = LocalDateExt().today()
            fetchLectures()
        }
        
        func showNextWeek() {
            timetableState.prevWeek = timetableState.week
            timetableState.week = timetableState.nextWeek
            timetableState.nextWeek = LocalDateExt().getWeekByNr(calendarWeek: timetableState.week!.calendarWeek + 1, year: timetableState.week!.year)
            fetchLectures()
        }
        
        func showPreviousWeek() {
            timetableState.nextWeek = timetableState.week
            timetableState.week = timetableState.prevWeek
            timetableState.prevWeek = LocalDateExt().getWeekByNr(calendarWeek: timetableState.week!.calendarWeek - 1, year: timetableState.week!.year)
            fetchLectures()
        }
        
        func showCurrentWeek() {
            timetableState.week = LocalDateExt().getCurrentWeek()
            timetableState.prevWeek = LocalDateExt().getWeekByNr(calendarWeek: _week.calendarWeek - 1, year: _week.year)
            timetableState.nextWeek = LocalDateExt().getWeekByNr(calendarWeek: _week.calendarWeek + 1, year: _week.year)
            fetchLectures()
        }
        

        init(lecturesDataSource: LecturesDataSource?) {
            self.lecturesDataSource = lecturesDataSource
        }
        
        // Set DB to access the queries.
        func setLecturesDataSource(lecturesDataSource: LecturesDataSource) {
            self.lecturesDataSource = lecturesDataSource
        }
    }
}
