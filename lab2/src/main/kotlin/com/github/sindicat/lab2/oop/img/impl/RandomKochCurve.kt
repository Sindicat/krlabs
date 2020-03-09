package com.github.sindicat.lab2.oop.img.impl

import com.github.sindicat.lab2.oop.img.ColorElement
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Path2D
import java.awt.geom.Point2D
import java.util.*

class RandomKochCurve(
    graph: Graphics2D,
    inColor: Color,
    outColor: Color,
    private val pInit: Point2D?,
    private val qInit: Point2D?,
    private val nInit: Int
): ColorElement(inColor, outColor, graph)  {

    companion object {
        val random = Random()
    }

    override fun draw() {
        drawRandomKochCurve(pInit, qInit, nInit)
    }

    fun drawRandomKochCurve(p: Point2D?, q: Point2D?, n: Int) {
        val w = randomSgn()
        val r: Point2D = Point2D.Double(
            (2 * p!!.x + q!!.x) / 3,
            (2 * p.y + q.y) / 3
        )
        val s: Point2D = Point2D.Double(
            (p.x + q.x) / 2 -
                    w * (p.y - q.y) * Math.sqrt(3.0) / 6,
            (p.y + q.y) / 2 +
                    w * (p.x - q.x) * Math.sqrt(3.0) / 6
        )
        val t: Point2D = Point2D.Double(
            (p.x + 2 * q.x) / 3,
            (p.y + 2 * q.y) / 3
        )
        val path: Path2D = Path2D.Double()
        path.moveTo(r.x, r.y)
        path.lineTo(s.x, s.y)
        path.lineTo(t.x, t.y)
        path.lineTo(r.x, r.y)
        path.closePath()
        if (w == 1) {
            graph.color = inColor
        } else  /* if w == -1 */ {
            graph.color = outColor
        }
        graph.fill(path)
        if (n == 0) {
            return
        }

        drawRandomKochCurve(p, r, n - 1)
        drawRandomKochCurve(r, s, n - 1)
        drawRandomKochCurve(s, t, n - 1)
        drawRandomKochCurve(t, q, n - 1)
    }

    private fun randomSgn(): Int {
        return random.nextInt(2) * 2 - 1
    }
}