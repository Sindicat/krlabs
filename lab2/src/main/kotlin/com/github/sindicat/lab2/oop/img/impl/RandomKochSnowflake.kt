package com.github.sindicat.lab2.oop.img.impl

import com.github.sindicat.lab2.oop.img.ColorElement
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Path2D
import java.awt.geom.Point2D
import kotlin.math.cos
import kotlin.math.sin

open class RandomKochSnowflake(
    inColor: Color,
    outColor: Color,
    graph: Graphics2D,
    protected val c: Point2D,
    protected val d: Double,
    protected val m: Int,
    protected val n: Int

) : ColorElement(inColor, outColor, graph) {

    override fun draw() {
        val vs = arrayOfNulls<Point2D>(m)
        for (i in 0 until m) {
            vs[i] = Point2D.Double(
                c.x + d * cos(2 * Math.PI / m * i),
                c.y - d * sin(2 * Math.PI / m * i)
            )
        }
        val path: Path2D = Path2D.Double()
        path.moveTo(vs[0]!!.x, vs[0]!!.y)
        for (i in 0 until m) {
            path.lineTo(vs[(i + 1) % m]!!.x, vs[(i + 1) % m]!!.y)
        }
        path.closePath()
        graph.color = inColor
        graph.fill(path)
        for (i in 0 until m) {
            RandomKochCurve(graph, inColor, outColor, vs[(i + 1) % m], vs[i], n).draw()
        }
    }


}