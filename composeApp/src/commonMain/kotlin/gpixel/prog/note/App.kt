package gpixel.prog.note

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.SlideTransition
import gpixel.prog.note.domain.auth
import gpixel.prog.note.ui.PreviewScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun App() = AppTheme {
    Box(Modifier.background(brush = gradient_background).fillMaxSize()) {
        Navigator(
            screen = homeScreen(),
        ) { navigator ->
            SlideTransition(navigator)
        }
    }
}

fun homeScreen() : Screen {
    return if (auth.isAuth()) {
        HomeScreen
    } else {
        PreviewScreen
    }
}

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient_background)
        ) {
            Button(
                onClick = {
                    navigator.push(PreviewScreen)
                },
            ) {
                Text("Create Account")
            }
        }
    }
}