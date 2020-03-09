package com.github.sindicat.lab2.oop.color

import java.awt.Color

class ColorResolver {

    fun getBetweenColor(
        startColor: Color, endColor: Color, p: Double
    ): Color {
        return Color(
            (startColor.red +
                    (endColor.red - startColor.red) * p).toInt(),
            (startColor.green +
                    (endColor.green - startColor.green) * p).toInt(),
            (startColor.blue +
                    (endColor.blue - startColor.blue) * p).toInt()
        )
    }

}