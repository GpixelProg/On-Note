package gpixel.prog.note.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import gpixel.prog.note.MainRes
import gpixel.prog.note.orangeColor
import io.github.skeptick.libres.compose.painterResource

object PreviewScreen : Screen {

    @Composable
    override fun Content() {
        Column {
            Image(
                painter = painterResource(image = MainRes.image.preview_logo),
                contentDescription = "Preview",
                modifier = Modifier.padding(top = 50.dp).padding(horizontal = 15.dp)
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
                onClick = {},
                modifier = Modifier
                    .padding(top = 50.dp)
                    .height(50.dp)
                    .fillMaxWidth().padding(horizontal = 20.dp)
                    .align(alignment = Alignment.CenterHorizontally),
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
                onClick = {},
                modifier = Modifier
                    .padding(top = 15.dp)
                    .height(50.dp)
                    .fillMaxWidth().padding(horizontal = 20.dp)
                    .align(alignment = Alignment.CenterHorizontally),
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