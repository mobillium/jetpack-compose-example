package com.mobillium.jetpack

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Expanded
import androidx.ui.layout.Padding
import androidx.ui.material.Slider
import androidx.ui.material.SliderPosition
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview

enum class Rgb {
    RED, GREEN, BLUE
}

@Model
data class ColorModel(
    var value: Float = 0.5f,
    val rgb: Rgb
)

@Composable
fun ColorSlider(color: ColorModel) {
    Padding(padding = 16.dp) {
        Slider(
            position = SliderPosition(initial = color.value, valueRange = 0f..1f),
            onValueChange = { p -> color.value = p },
            color = when (color.rgb) {
                Rgb.RED -> Color.Red
                Rgb.GREEN -> Color.Green
                Rgb.BLUE -> Color.Blue
            }
        )
    }
}

@Composable
fun ColorPicker() {
    val red = ColorModel(rgb = Rgb.RED)
    val green = ColorModel(rgb = Rgb.GREEN)
    val blue = ColorModel(rgb = Rgb.BLUE)

    Column {
        ColorSlider(color = red)
        ColorSlider(color = green)
        ColorSlider(color = blue)
        Surface (modifier = Expanded, color = Color(red.value, green.value, blue.value)) {
            Text(text = "r(${red.value}), g(${green.value}), b(${blue.value})")
        }
    }
}

@Preview
@Composable
fun ColorPickerPreview() {
    ColorPicker()
}