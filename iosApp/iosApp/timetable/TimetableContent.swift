import Foundation
import SwiftUI
import shared

let hourHeight: CGFloat = 52
let weekdays = ["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"]

struct TimetableContent: View {
    let lectures: [LectureObjectDto]?
    let hours: [String] = (7...22).map { "\($0):00" }
    
    var body: some View {
        ScrollView(.vertical) {
            ZStack {
                // Divider between the hours.
                VStack(alignment: .leading, spacing: hourHeight-1) {
                    ForEach(hours, id: \.self) { hour in
                        Divider()
                            .background(Color.gray)
                            .offset(x: 40, y: -10)
                            .frame(height: 1)
                    }
                }
                HStack(alignment: .top) {
                    HourSlots(hours: hours)
                    WeekdayColumns(lectures: lectures)
                    
                }
                .frame(minHeight: UIScreen.main.bounds.height)
            }
            
        }
    }
}

struct HourSlots: View {
    let hours: [String]
    
    var body: some View {
        VStack(alignment: .center, spacing: 0) {
            ForEach(hours, id: \.self) { hour in
                Text(hour).font(.system(size: 12))
                    .padding(.leading, 4)
                    .frame(height: hourHeight)
            }
        }
    }
}

struct WeekdayColumns: View {
    let lectures: [LectureObjectDto]?
    
    var body: some View {
        HStack(spacing: 0) {
            ForEach(weekdays.indices, id: \.self) { index in
                ZStack(alignment: .top) {
                    // Background
                    Rectangle()
                        .fill(Color.clear)
                        .frame(maxWidth: .infinity)
                        .border(Color.gray, width: 0.5)
                    
                    // LessonCards for the day.
                    ZStack(alignment: .top) {
                        ForEach(lectures?.filter { $0.weekday == weekdays[index] } ?? [], id: \.self) { lecture in
                            LessonCard(lecture: lecture)
                                .offset(y: calculateCardOffset(startTime: lecture.start))
                        }
                    }
                }
            }
        }
    }
}

func calculateCardOffset(startTime: String) -> CGFloat {
    let start = LocalDateExt().stringToLocalTime(timeString: startTime)
    let hour = CGFloat(start.hour - 7)
    let min = CGFloat(start.minute) / 60
    return hour * hourHeight + min * hourHeight + 26
}

func calculateCardHeight(start: String, end: String) -> CGFloat {
    return LocalDateExt().calculateHours(start: start, end: end) * hourHeight
}

