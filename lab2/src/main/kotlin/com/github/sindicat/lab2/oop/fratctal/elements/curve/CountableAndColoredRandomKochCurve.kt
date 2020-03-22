package com.github.sindicat.lab2.oop.fratctal.elements.curve

import com.github.sindicat.lab2.oop.fratctal.elements.ColorElement
import com.github.sindicat.lab2.oop.fratctal.elements.CountableElement
import java.awt.Color
import java.awt.Graphics2D

abstract class CountableAndColoredRandomKochCurve(
    graph: Graphics2D,
    inColor: Color,
    outColor: Color) : ColorElement(inColor, outColor, graph),
    CountableElement {

    override fun count() {
        counter++
    }

    override fun getCounter(): Long =
        counter

    override fun resetCounter() {
        counter = 0
    }

    companion object CounterStorage {
        private var counter: Long = 0L
    }

}