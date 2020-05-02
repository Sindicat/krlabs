package com.github.sindicat.lab6_1.model

import kotlin.math.pow
import kotlin.math.sin

class Triangle(
    val a: Double?,
    val b: Double?,
    val c: Double?,
    val base: Double?,
    val height: Double?,
    val angle: Double?
) : Shape {

    override fun getArea(): Double? {
        return if (a != null && b != null && angle != null) {
            0.5 * a * b  * sin(angle)

        } else if (areSidesSet()) {
            (1.0 / 4) * ((a!! + b!! + c!!) * (b + c - a) * (a + c - b) * (a + b - c)).pow(0.5)

        } else if (base != null && height != null) {
            0.5 * base * height
        } else null
    }

    override fun getPerimeter(): Double? = if (areSidesSet()) a!! + b!! + c!! else null

    override fun getRadiusExternal(): Double? {
        return if (areSidesSet() && getArea() != null) {
            (a!! * b!! * c!!) / (4 * getArea()!!)
        } else null
    }

    override fun getRadiusInternal(): Double? {
        return if (getHalfOfPerimeter() != null) {
            (((getHalfOfPerimeter()!! - a!!) * (getHalfOfPerimeter()!! - b!!) * (getHalfOfPerimeter()!! - c!!)) / (4 * getHalfOfPerimeter()!!)).pow(0.5)
        } else null
    }

    private fun getHalfOfPerimeter(): Double? = if (getPerimeter() != null) getPerimeter()!! / 2 else null

    private fun areSidesSet(): Boolean = a != null && b != null && c != null
}