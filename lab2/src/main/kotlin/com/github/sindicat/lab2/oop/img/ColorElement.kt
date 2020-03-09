package com.github.sindicat.lab2.oop.img

import java.awt.Color
import java.awt.Graphics2D

abstract class ColorElement(
    protected val inColor: Color,
    protected val outColor: Color,
    protected val graph: Graphics2D
) : DrawableElement