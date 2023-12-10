import SwiftUI
import shared

struct ContentView: View {
    let greet = LocalDateExt().formatDate()
    let greetData = GreetingFuncData().greet()
    let greetApi = GreetingApi().greet()
    let greetDB = GreetingDB().greet()
    let greetEnt = GreetingEnt().greet()
    
    let weekdays = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
    let hours = Array(7...22)
    
    var body: some View {
        VStack {
            Text(String())
            // Indicator for the month and year
            Text("December 2023")
                .font(.subheadline) // Smaller Font
                .padding()
            
            // Timetable header
            HStack {
                VStack {
                    Text("KW") // Calendar Week indicator
                    Text("42") // Placeholder for the calendar week number
                }
                Spacer()
                ForEach(weekdays, id: \.self) { day in
                    VStack {
                        Text(day.prefix(2))
                        Text("4") // Placeholder for the date
                    }
                    .frame(width: 30)
                }
            }
            .padding()
            
            // Timetable content
            ScrollView {
                LazyVGrid(columns: Array(repeating: GridItem(), count: 8), spacing: 0) {
                    ForEach(hours, id: \.self) { hour in
                        HStack {
                            // Time indicator
                            Text("\(hour):00")
                                .frame(width: 60, alignment: .trailing)
                                .padding(.trailing, 5)
                            
                            // Day columns
                            ForEach(weekdays, id: \.self) { _ in
                                // Add your content here for each cell in the timetable
                                // You may want to customize this based on your needs
                                Rectangle()
                                    .frame(width: 60, height: 40)
                                    .border(Color.blue)
                            }
                        }
                    }
                }
            }
        }
        .padding()
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
