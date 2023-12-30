import Foundation
import SwiftUI
import shared

/*
 View for the header showing the week with its days.
 */
struct TimetableHeader: View {
    let week: YearWeek?
    let weekDays: [String]
    let today: DateUtil?
    
    var body: some View {
        HStack(spacing: 0) {
            VStack(alignment: .center, spacing: 0) {
                Text("KW")
                    .font(.system(size: 14, weight: .semibold))
                Text("\(week?.calendarWeek ?? 0)")
                    .font(.system(size: 14, weight: .bold))
            }.frame(maxWidth: 40).padding(.leading, 4)
            HStack(spacing: 0) {
                ForEach(weekDays, id: \.self) { day in
                    HeaderItem(day: day, date: week?.days[weekDays.firstIndex(of: day) ?? 0], today: today)
                        .frame(maxWidth: .infinity)
                }
            }.frame(maxWidth: .infinity, maxHeight: 48)
        }
        .frame(maxWidth: .infinity)
        .padding([.top, .bottom], 16)
    }
}

struct HeaderItem: View {
    let day: String
    let date: DateUtil?
    let today: DateUtil?
    
    var body: some View {
        ZStack {
            Circle()
                // Highlight the current day.
                .fill(date == today ? Color.teal.opacity(0.5) : Color.gray.opacity(0.5))
                .frame(width: 36, height: 36)
            VStack {
                Text(day.prefix(2))
                    .font(.system(size: 12))
                Text("\(date?.day ?? 0)")
                    .font(.system(size: 14, weight: .semibold))
            }
            .foregroundColor(.primary)
        }
    }
}
