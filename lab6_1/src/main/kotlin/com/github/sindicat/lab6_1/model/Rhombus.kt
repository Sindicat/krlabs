package com.github.sindicat.lab6_1.model

import kotlin.math.pow
import kotlin.math.sin

class Rhombus(
    val diagonalA: Double?,
    val diagonalB: Double?,
    val side: Double?,
    val angle: Double?
) : Shape {

    override fun getArea(): Double? {
        return if(side != null && angle != null) {
            side.pow(2) * sin(angle)
        } else if (diagonalA != null && diagonalB != null) {
            (diagonalA * diagonalB) / 2
        }
        else null
    }

    override fun getPerimeter(): Double? {
        return if (diagonalA != null && diagonalB != null) 4 * calculateSideLength()
        else null
    }

    override fun getRadiusExternal(): Double? {
        return if (diagonalA != null && diagonalB != null) {
            if (isSquare()) diagonalA / 2 else -1.0
        } else null
    }

    override fun getRadiusInternal(): Double? {
        return if (diagonalA != null && diagonalB != null) (diagonalA * diagonalB) / (4 * calculateSideLength())
        else null
    }

    private fun calculateSideLength(): Double = (diagonalA!!.pow(2) + diagonalB!!.pow(2)).pow(0.5)

    private fun isSquare(): Boolean {
        return if (diagonalA == null || diagonalB == null) false
        else diagonalA.compareTo(diagonalB) == 0
    }

}