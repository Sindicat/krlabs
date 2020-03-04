package com.github.sindicat.lab1

import java.lang.Exception
import kotlin.math.pow
import kotlin.math.roundToLong

fun main(args: Array<String>) {
    while (true) {
        try {
            val x: Double = getAngleValue()
            val precision: Int = getPrecisionValue()
            println("cos($x)=${cos(x, precision)}")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}

internal fun getPrecisionValue(): Int {
    print("Enter precision (Integer value): ")
    try {
        return readLine()!!.toInt().also {
            if (it > 308) throw IllegalArgumentException("Too large value for precision. Max precision 308 decimal places")
            if (it < 0) throw IllegalArgumentException("Precision must be greater zero.")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Incorrect input. Please, enter Integer value.")
    }
}

internal fun getAngleValue(): Double {
    print("Enter the angle value in radians (Double value) X = ")
    try {
        return readLine()!!.toDouble()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Incorrect input. Please, enter Double value.")
    }
}

internal fun cos(x: Double, precision: Int): Double {
    var angleInRadians = x % (2 * Math.PI)
    var currentElement = 1.0
    var sum = 0.0
    var index = 1
    while (precisionIsChanging(sum, precision, currentElement)) {
        sum += currentElement
        currentElement =
            nextSequenceElement(index++, angleInRadians, currentElement)
    }
    return sum.round(precision)
}

private fun nextSequenceElement(i: Int, x: Double, prevElement: Double): Double =
    -1 * prevElement * ((x.pow(2.0)) / ((2 * i - 1) * 2 * i))

private fun precisionIsChanging(sum: Double, precision: Int, nextElement: Double): Boolean =
    sum.round(precision).compareTo((sum + nextElement).round(precision)) != 0

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return (this * multiplier).roundToLong() / multiplier
}