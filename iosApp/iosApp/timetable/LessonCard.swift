import SwiftUI
import shared

struct LessonCard: View {
    var lecture: LectureObjectDto

    var body: some View {
        CardView {
            VStack {
                Text(lecture.module)
                    .font(.system(size: 10, weight: .semibold))
                    .kerning(-0.05)
                    .lineSpacing(1)
                    .lineLimit(4)
                    .truncationMode(.tail)

                Spacer().frame(height: 2)

                Text(lecture.rooms)
                    .font(.system(size: 10))
                    .kerning(-0.5)
                    .lineSpacing(1)
                Spacer()
            }
            .padding(2)
        }
        .frame(height: calculateCardHeight(start: lecture.start, end: lecture.end))
        .padding(.horizontal, 1)
    }
}

// CardView needs to be implemented since it's not in SwiftUI.
struct CardView<Content: View>: View {
    let content: Content

    init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }

    var body: some View {
        content
            .background(Color.green.opacity(0.75))
            .cornerRadius(8)
            .shadow(radius: 5)
    }
}
