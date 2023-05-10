package gpixel.prog.note.ui.components.squircle

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Maksym Stanislavenko - GpixelProg.
 * The Squircle TextField is a custom button that has a squircle shape.
 */

@Composable
fun SquircleTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current.copy(
        color = Color.White,
        fontSize = 16.sp,
        textDecoration = TextDecoration.None
    ),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    cursorBrush: SolidColor = SolidColor(Color.White),
    placeholderText: String = "Text",
    placeholderTextSize: TextUnit = 16.sp,
    placeholderTextColor: Color = Color.Gray,
    placeholderFontFamily: FontFamily = textStyle.fontFamily ?: FontFamily.Default,
    shapeRadius: Dp = 5.dp,
    shapeFillColor: Color = Color(0xFF2B2639),
    shapeStrokeColor: Color = Color(0xFFC4C4C4),
    shapeStrokeWidth: Dp = 2.dp,
) {

    Box(modifier = modifier) {
        SquircleShape(
            modifier = Modifier.fillMaxSize(),
            radius = shapeRadius,
            fillColor = shapeFillColor,
            strokeColor = shapeStrokeColor,
            strokeWidth = shapeStrokeWidth,
        )

        val textModifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .align(Alignment.Center)

        BasicTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            modifier = textModifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            visualTransformation = visualTransformation,
            cursorBrush = cursorBrush,
        )

        /**
         * Placeholder
         */
        if (value.isEmpty()) {
            Text(
                modifier = textModifier,
                text = placeholderText,
                color = placeholderTextColor,
                fontSize = placeholderTextSize,
                fontFamily = placeholderFontFamily,
            )
        }
    }
}