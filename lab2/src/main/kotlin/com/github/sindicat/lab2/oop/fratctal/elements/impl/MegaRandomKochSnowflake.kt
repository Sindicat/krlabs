package com.github.sindicat.lab2.oop.fratctal.elements.impl

import com.github.sindicat.lab2.oop.color.ColorResolver
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Point2D

class MegaRandomKochSnowflake(
    inColor: Color,
    private val endColor: Color,
    outColor: Color,
    graph: Graphics2D,
    c: Point2D,
    d: Double,
    m: Int,
    private val k: Int,
    n: Int
) : RandomKochSnowflake(inColor, outColor, graph, c, d, m, n) {

    private val colorResolver: ColorResolver = ColorResolver()

    override fun draw() {
        RandomKochSnowflake(
            endColor,
            outColor,
            graph,
            c,
            d,
            m,
            n
        ).draw()
        for (i in 1 until k) {
            RandomKochSnowflake(
                colorResolver.getBetweenColor(endColor, inColor, i.toDouble() / k),
                colorResolver.getBetweenColor(
                    endColor,
                    inColor,
                    (i - 1).toDouble() / k
                ),
                graph,
                c,
                d * (k - i) / k,
                m,
                n
            ).draw()
        }
    }
}