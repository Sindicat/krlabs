package com.github.sindicat

import kotlin.math.pow
import kotlin.math.roundToLong

fun main(args: Array<String>) {
}

fun cos(x: Double, precision: Int): Double {
    var angleInRadians = x % (2 * Math.PI)
    var currentElement = 1.0
    var sum = 0.0
    var index = 1
    while (precisionIsChanging(sum, precision, currentElement)) {
        sum += currentElement
        currentElement = nextSequenceElement(index++, angleInRadians, currentElement)
    }
    return sum.round(precision)
}

private fun nextSequenceElement(i: Int, x: Double, prevElement: Double): Double =
    -1 * prevElement * ((x.pow(2.0)) / ((2 * i - 1) * 2 * i))

private fun precisionIsChanging(sum: Double, precision: Int, nextElement: Double) =
    sum.round(precision).compareTo((sum + nextElement).round(precision)) != 0

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return (this * multiplier).roundToLong() / multiplier
}