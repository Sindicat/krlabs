package com.github.sindicat.lab2.oop.fratctal


private const val WIDTH = 640
private const val HEIGHT = 480
private const val m = 6
private const val k = 3
private const val n = 4

fun main(args: Array<String>) {
    RandomKochSnowflakesFractal(WIDTH, HEIGHT, m, k, n).draw()
}