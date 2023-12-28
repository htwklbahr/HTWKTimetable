import SwiftUI
import shared

struct TimetableScreen: View {
    private var lecturesDataSource: LecturesDataSource
    
    @StateObject private var viewModel = TimetableViewModel(lecturesDataSource: nil)
    
    init(lecturesDataSource: LecturesDataSource) {
        self.lecturesDataSource = lecturesDataSource
    }
    
    var body: some View {
        VStack {
            Text(viewModel.filteresLectures.first?.lecturer ?? "Pups")
            printPlaceholder()
            Text(LocalDateExt().formatDate())
           printPlaceholder2()
        }.onAppear {
            viewModel.setLecturesDataSource(lecturesDataSource: lecturesDataSource)
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
    
    private func printPlaceholder2() -> Text {
        switch viewModel.placeholder {
        case .loading:
            return Text("Loading ...")
        case .result(let data):
            return Text(data?.first?.name ?? "no data")
        case .error(let description):
            return Text(description)
        }
    }
}
