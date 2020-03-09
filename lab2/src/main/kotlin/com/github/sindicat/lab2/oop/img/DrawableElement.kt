package com.github.sindicat.lab2.oop.img

import java.awt.Color
import java.awt.Graphics2D

abstract class DrawableElement(
    protected val inColor: Color,
    protected val outColor: Color,
    val graph: Graphics2D
) {

    abstract fun draw()

}