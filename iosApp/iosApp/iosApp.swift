import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
            .preferredColorScheme(.dark)
        }
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.keyboard)
    }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}