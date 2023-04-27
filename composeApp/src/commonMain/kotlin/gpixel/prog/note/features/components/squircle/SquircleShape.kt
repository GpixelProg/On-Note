package gpixel.prog.note.features.components.squircle

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * The squircle shape component. Created by Maksym Stanislavenko - GpixelProg.
 *
 * @param radius The radius of the squircle.
 * @param fillColor The color of the squircle.
 * @param strokeColor The color of the stroke.
 * @param strokeWidth The width of the stroke.
 * @param roundPower The round power of the squircle, default 2.5f.
 */

@Composable
fun SquircleShape(
    modifier: Modifier = Modifier.height(100.dp).width(100.dp),
    radius: Dp = 20.dp,
    fillColor: Color = MaterialTheme.colors.onSurface,
    strokeColor: Color = Color.Transparent,
    strokeWidth: Dp = 0.dp,
    roundPower: Float = 3.5f
) {
    val squircleSize = remember { mutableStateOf(Size(100.dp.toPx(), 100.dp.toPx())) }
    val squircleRadius = remember { mutableStateOf(radius.toPx()) }
    val squirclePath = remember { mutableStateOf(Path()) }
    val density = LocalDensity.current

    /**
     * [ TEST ONLY !!! ]
     * The slider to test the squircle shape radius.
     */
    val testSquircleRadius = false
    if (testSquircleRadius) {
        Box(modifier = Modifier.padding(20.dp)) {
            Slider(
                value = squircleRadius.value,
                onValueChange = { value ->
                    squircleRadius.value = value
                    updateSquirclePath(squircleSize.value, squircleRadius.value, squirclePath, density, roundPower)
                },
                valueRange = 0f..(squircleSize.value.width / 2),
                steps = 50,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {

                squircleSize.value = size

                drawPath(
                    squirclePath.value,
                    color = strokeColor,
                    style = Stroke(width = strokeWidth.toPx())
                )
                drawPath(
                    squirclePath.value,
                    color = fillColor,
                    style = Fill
                )
            }
        )

        rememberCoroutineScope().launch {
            updateSquirclePath(size = squircleSize.value, squircleRadius.value, squirclePath, density, roundPower)
        }
    }
}

fun Dp.toPx(): Float = value * 2
fun Dp.toPx(density: Density): Float = value * density.density

fun updateSquirclePath(size: Size, radius: Float, squirclePath: MutableState<Path>, density: Density, roundPower: Float) {
    val rect = Rect(0f, 0f, size.width, size.height)
    val cornerRadius = radius.dp.toPx(density)

    /**
     * Round power of squircle, default is 2.5f
     */
    val n = roundPower

    squirclePath.value = Path().apply {
        moveTo(rect.left, rect.top + cornerRadius)
        cubicTo(rect.left, rect.top + cornerRadius / n, rect.left + cornerRadius / n, rect.top,
            rect.left + cornerRadius, rect.top)
        lineTo(rect.right - cornerRadius, rect.top)
        cubicTo(rect.right - cornerRadius / n, rect.top, rect.right, rect.top + cornerRadius / n,
            rect.right, rect.top + cornerRadius)
        lineTo(rect.right, rect.bottom - cornerRadius)
        cubicTo(rect.right, rect.bottom - cornerRadius / n, rect.right - cornerRadius / n, rect.bottom,
            rect.right - cornerRadius, rect.bottom)
        lineTo(rect.left + cornerRadius, rect.bottom)
        cubicTo(rect.left + cornerRadius / n, rect.bottom, rect.left, rect.bottom - cornerRadius / n,
            rect.left, rect.bottom - cornerRadius)
        close()
    }
}