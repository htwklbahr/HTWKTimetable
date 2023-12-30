import SwiftUI
import shared

/*
 View for the Topbar showing the month, year and a button to return to current day.
 */
struct TopBar: View {
    let week: YearWeek?
    let action: () -> Void
    
    var body: some View {
        HStack {
            if let firstDay = week?.days.first {
               let month = firstDay.month.name
               let year = String(format: "%d", firstDay.year)
                Text("\(month) \(year)")
                    .font(.system(size: 18))
                    .padding(.trailing, 4)
            }
            Button(action: action) {
                Image(systemName: "calendar")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 22, height: 22)
                    .foregroundColor(Color.black)
            }
        }
        .padding(.top, 16)
    }
}
