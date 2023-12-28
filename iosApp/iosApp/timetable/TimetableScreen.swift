import SwiftUI
import shared

struct TimetableScreen: View {
    private var lecturesDataSource: LecturesDataSource
    
    @StateObject private var viewModel = TimetableViewModel(lecturesDataSource: nil)
    
    init(lecturesDataSource: LecturesDataSource) {
        self.lecturesDataSource = lecturesDataSource
    }
    
    var body: some View {
        // Detect swiping for changing the displayed week.
        let dragGesture = DragGesture()
            .onEnded { value in
                if value.translation.width > 100 {
                    viewModel.showPreviousWeek() // Swipe right.
                } else if value.translation.width < -100 {
                    viewModel.showNextWeek() // Swipe left.
                }
            }
        
        VStack(spacing: 0) {
            TopBar(
                week: viewModel.timetableState.week,
                action: viewModel.showCurrentWeek
            )
            TimetableHeader(
                week: viewModel.timetableState.week,
                weekDays: viewModel.timetableState.weekDays,
                today: viewModel.timetableState.today)
            TimetableContent()
                .gesture(dragGesture)
        }
        .onAppear {
            viewModel.setLecturesDataSource(lecturesDataSource: lecturesDataSource)
            viewModel.fetchData()
        }
    }
    
    private func printPlaceholder() -> Text {
        switch viewModel.lecture {
        case .loading:
            return Text("Loading ...")
        case .result(let data):
            return Text(data?.first?.module ?? "no data")
        case .error(let description):
            return Text(description)
        }
    }
}
