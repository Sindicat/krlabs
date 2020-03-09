package com.github.sindicat.lab2.oop.img.impl

import com.github.sindicat.lab2.oop.color.ColorResolver
import com.github.sindicat.lab2.oop.img.DrawableElement
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Point2D

class MegaRandomSnowFlake(
    inColor: Color,
    private val endColor: Color,
    outColor: Color,
    graph: Graphics2D,
    private val c: Point2D,
    private val d: Double,
    private val m: Int,
    private val k: Int,
    private val n: Int
) : DrawableElement(inColor, outColor, graph) {

    private val colorResolver: ColorResolver = ColorResolver()

    override fun draw() {
        RandomKochSnowflake(endColor, outColor, graph, c, d, m, n).draw()
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