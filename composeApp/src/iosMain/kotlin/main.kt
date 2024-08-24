import androidx.compose.ui.window.ComposeUIViewController
import com.gpixelprog.notes.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
