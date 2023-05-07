package gpixel.prog.note.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gpixel.prog.note.features.components.squircle.SquircleShape
import gpixel.prog.note.features.components.squircle.SquircleTextField
import gpixel.prog.note.gradient_background

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TestScreen() {
    val keyController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    keyController?.hide()
                }
            }
            .background(brush = gradient_background)
    ) {
        SquircleShape(
            modifier = Modifier.height(200.dp).width(200.dp).padding(20.dp),
            radius = 20.dp,
            fillColor = Color(0xFF2B2639),
            strokeColor = Color(0xFFC4C4C4),
            strokeWidth = 2.dp,
        )

        var text2 by remember { mutableStateOf("") }

        TextField(
            value = text2,
            onValueChange = { text2 = it },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            textStyle = LocalTextStyle.current.copy(
                color = Color.White,
                fontSize = 16.sp,
                textDecoration = TextDecoration.None
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedIndicatorColor = Color(0xFF2B2639),
                unfocusedIndicatorColor = Color(0xFF2B2639),
                disabledIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
        )

        var value by remember { mutableStateOf("") }

        SquircleTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(40.dp),
            value = value,
            onValueChange = {
                value = it
                if (value.last() == '\n') {
                    value = value.dropLast(1)
                    keyController?.hide()
                }
            },
        )
    }
}