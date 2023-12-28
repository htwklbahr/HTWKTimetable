import Foundation
import SwiftUI
import shared

struct TimetableContent: View {
    let hours: [String] = (7...22).map { "\($0):00" }
    let weekdays = ["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"]
    let hourHeight: CGFloat = 52
    
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
                    HourSlots(hours: hours, hourHeight: hourHeight)
                    WeekdayColumns(weekdays: weekdays, hourHeight: hourHeight)
                    
                }
                .frame(minHeight: UIScreen.main.bounds.height)
            }
            
        }
    }
}

struct HourSlots: View {
    let hours: [String]
    let hourHeight: CGFloat
    
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
    let weekdays: [String]
    let hourHeight: CGFloat
    //let lectures: [LectureObjectDto] // Definieren Sie Ihre Lecture-Struktur entsprechend.
    
    var body: some View {
        HStack(spacing: 0) {
            ForEach(0..<7) { _ in
                Rectangle()
                    .fill(Color.clear) // Die Farbe kann angepasst werden, um die Spalten sichtbar zu machen
                    .frame(maxWidth: .infinity) // Füllt die verfügbare Breite gleichmäßig
                    .border(Color.gray, width: 0.5) // Fügt eine Grenzlinie zwischen den Spalten hinzu
            }
        }
    }
}

