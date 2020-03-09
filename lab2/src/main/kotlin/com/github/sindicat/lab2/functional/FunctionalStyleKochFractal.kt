package com.github.sindicat.lab2.functional

import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Path2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

private const val WIDTH = 640
private const val HEIGHT = 480
private var image: BufferedImage = BufferedImage(
    WIDTH,
    HEIGHT, BufferedImage.TYPE_INT_RGB)
private lateinit var graph: Graphics2D
private val random = Random()

fun main(args: Array<String>) {
    image = BufferedImage(
        WIDTH,
        HEIGHT, BufferedImage.TYPE_INT_RGB)
    graph = image.createGraphics()
    graph.color = Color.BLUE
    graph.fill(Rectangle2D.Double(0.0, 0.0, WIDTH.toDouble(), HEIGHT.toDouble()))
    // drawRandomKochSnowflake(new Point2D.Double(WIDTH / 2, HEIGHT / 2),
// WIDTH / 3, 4, 4, Color.GREEN, Color.BLUE);
    drawKochMegaSnowflake(
        Point2D.Double(
            (WIDTH / 2).toDouble(),
            (HEIGHT / 2).toDouble()
        ),
        WIDTH / 3.toDouble(),
        6,
        3,
        4,
        Color.GREEN,
        Color.ORANGE,
        Color.BLUE
    )
    val frame = JFrame()
    frame.addNotify()
    frame.setSize(
        frame.insets.left +
                frame.insets.right + WIDTH,
        frame.insets.top +
                frame.insets.bottom + HEIGHT
    )
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.add(object : JPanel() {
        public override fun paintComponent(g: Graphics) {
            val G = g as Graphics2D
            if (image != null) {
                G.drawImage(image, 0, 0, null)
            }
        }
    })
    frame.isVisible = true
}

private fun randomSgn(): Int {
    return random.nextInt(2) * 2 - 1
}

private fun drawRandomKochCurve(
    p: Point2D?, q: Point2D?, n: Int,
    inColor: Color, outColor: Color
) {
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
        graph!!.color = inColor
    } else  /* if w == -1 */ {
        graph!!.color = outColor
    }
    graph!!.fill(path)
    if (n == 0) {
        return
    }
    drawRandomKochCurve(p, r, n - 1, inColor, outColor)
    drawRandomKochCurve(r, s, n - 1, inColor, outColor)
    drawRandomKochCurve(s, t, n - 1, inColor, outColor)
    drawRandomKochCurve(t, q, n - 1, inColor, outColor)
}

private fun drawRandomKochSnowflake(
    c: Point2D, d: Double,
    m: Int, n: Int,
    inColor: Color, outColor: Color
) {
    val vs = arrayOfNulls<Point2D>(m)
    for (i in 0 until m) {
        vs[i] = Point2D.Double(
            c.x + d * Math.cos(2 * Math.PI / m * i),
            c.y - d * Math.sin(2 * Math.PI / m * i)
        )
    }
    val path: Path2D = Path2D.Double()
    path.moveTo(vs[0]!!.x, vs[0]!!.y)
    for (i in 0 until m) {
        path.lineTo(vs[(i + 1) % m]!!.x, vs[(i + 1) % m]!!.y)
    }
    path.closePath()
    graph!!.color = inColor
    graph!!.fill(path)
    for (i in 0 until m) {
        drawRandomKochCurve(
            vs[(i + 1) % m],
            vs[i],
            n,
            inColor,
            outColor
        )
    }
}

private fun getBetweenColor(
    startColor: Color, endColor: Color, p: Double
): Color {
    return Color(
        (startColor.red +
                (endColor.red - startColor.red) * p).toInt(),
        (startColor.green +
                (endColor.green - startColor.green) * p).toInt(),
        (startColor.blue +
                (endColor.blue - startColor.blue) * p).toInt()
    )
}

private fun drawKochMegaSnowflake(
    c: Point2D, d: Double,
    m: Int, k: Int, n: Int,
    inColor: Color, endColor: Color, outColor: Color
) {
    drawRandomKochSnowflake(c, d, m, n, endColor, outColor)
    for (i in 1 until k) {
        drawRandomKochSnowflake(
            c, d * (k - i) / k, m, n,
            getBetweenColor(endColor, inColor, i.toDouble() / k),
            getBetweenColor(
                endColor,
                inColor,
                (i - 1).toDouble() / k
            )
        )
    }
}