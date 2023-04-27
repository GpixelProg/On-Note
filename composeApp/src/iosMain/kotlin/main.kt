import androidx.compose.ui.window.ComposeUIViewController
import gpixel.prog.note.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
