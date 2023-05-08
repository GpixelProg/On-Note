package gpixel.prog.note.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gpixel.prog.note.MainRes
import gpixel.prog.note.view_models.PreviewModel
import gpixel.prog.note.orangeColor
import gpixel.prog.note.platform.getTopPadding
import io.github.skeptick.libres.compose.painterResource

object PreviewScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val previewModel = rememberScreenModel { PreviewModel(navigator) }

        Column(modifier = Modifier.padding(top = getTopPadding())) {
            Image(
                painter = painterResource(image = MainRes.image.preview_logo),
                contentDescription = "Preview",
                modifier = Modifier.padding(top = 15.dp).padding(horizontal = 15.dp)
            )

            Text(
                text = "The best solution for notes",
                modifier = Modifier.padding(top = 15.dp).padding(horizontal = 20.dp),
                fontSize = 24.sp,
                color = Color.White,
            )

            Text(
                text = "Creating notes and tasks has never been so easy",
                modifier = Modifier.padding(top = 5.dp).padding(horizontal = 20.dp),
                fontSize = 14.sp,
                color = Color.White,
            )

            // Rounded button Create account
            Button(
                onClick = { previewModel.createAccount() },
                modifier = Modifier
                    .padding(top = 50.dp)
                    .height(45.dp)
                    .fillMaxWidth().padding(horizontal = 20.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .shadow(4.dp, RoundedCornerShape(50)),
                shape = RoundedCornerShape(percent = 50),
                colors = ButtonDefaults.buttonColors(backgroundColor = orangeColor)
            ) {
                Text(
                    text = "Create Account",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontFamily = FontFamily.Default,
                )
            }

            // Rounded button Log In
            Button(
                onClick = { previewModel.onLogin() },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .height(45.dp)
                    .fillMaxWidth().padding(horizontal = 20.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .shadow(4.dp, RoundedCornerShape(50)),
                shape = RoundedCornerShape(percent = 50),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Text(
                    text = "Log In",
                    fontSize = 18.sp,
                    color = orangeColor,
                    fontFamily = FontFamily.Default,
                )
            }
        }
    }
}