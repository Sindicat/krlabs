package com.github.sindicat.lab2.oop.fratctal

import com.github.sindicat.lab2.oop.fratctal.elements.impl.MegaRandomKochSnowflake
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import javax.swing.JFrame
import javax.swing.JPanel

private const val WIDTH = 640
private const val HEIGHT = 480
private const val m = 6
private const val k = 3
private const val n = 4

fun main(args: Array<String>) {
    val image = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
    val graph: Graphics2D = image.createGraphics().apply {
        color = Color.BLUE
        fill(Rectangle2D.Double(0.0, 0.0, WIDTH.toDouble(), HEIGHT.toDouble()))
    }
    MegaRandomKochSnowflake(
        Color.GREEN, Color.ORANGE, Color.BLUE, graph,
        Point2D.Double((WIDTH / 2).toDouble(), (HEIGHT / 2).toDouble()),
        WIDTH / 3.toDouble(), m, k, n
    ).draw()
    JFrame().apply {
        addNotify()
        setSize(
            insets.left + insets.right + WIDTH,
            insets.top + insets.bottom + HEIGHT
        )
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        add(object : JPanel() {
            public override fun paintComponent(g: Graphics) {
                g.drawImage(image, 0, 0, null)
            }
        })
        isVisible = true
    }
}