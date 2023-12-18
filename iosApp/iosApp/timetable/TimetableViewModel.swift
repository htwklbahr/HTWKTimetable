import Foundation
import shared

extension TimetableScreen {
    
    enum Loadable {
        case loading
        case result([LectureObjectDto]?)
        case error(String)
    }
    
    enum LoadablePH {
        case loading
        case result([PlaceholderObject]?)
        case error(String)
    }
    
    @MainActor
    class TimetableViewModel: ObservableObject {
        private var lecturesDataSource: LecturesDataSource?
        
        private var lectures = [LectureObjectDto]()
        @Published private(set) var filteresLectures = [LectureObjectDto]()
        
        @Published var lecture = Loadable.loading
        
        init(lecturesDataSource: LecturesDataSource?) {
            self.lecturesDataSource = lecturesDataSource
            self.loadLectures()
            self.loadPlacholder()
        }
        
        func loadLectures() {
            Task {
                do {
                    self.lecture = .loading
                    let data = try await self.lecturesDataSource?.getLectures()
                    self.lecture = .result(data)
                } catch {
                    self.lecture = .error(error.localizedDescription)
                }
            }
            
//            self.lecturesDataSource?.getLectures(completionHandler: { lectures, error in
//                self.lectures = lectures ?? []
//                self.filteresLectures = self.lectures
//            })
        }
        
        func setLecturesDataSource(lecturesDataSource: LecturesDataSource) {
            self.lecturesDataSource = lecturesDataSource
        }
        
        @Published var placeholder = LoadablePH.loading
        
        func loadPlacholder() {
            Task {
                do {
                    self.placeholder = .loading
                    let data = try await self.lecturesDataSource?.getPlaceholderData()
                    self.placeholder = .result(data)
                } catch {
                    self.placeholder = .error("error")
                }
            }
        }
        
        
        
    }
}
