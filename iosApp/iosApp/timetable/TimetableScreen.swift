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
            TimetableContent(lectures: viewModel.timetableState.lectures)
                .gesture(dragGesture)
        }
        .onAppear {
            viewModel.setLecturesDataSource(lecturesDataSource: lecturesDataSource)
            viewModel.fetchData()
        }
    }
}
