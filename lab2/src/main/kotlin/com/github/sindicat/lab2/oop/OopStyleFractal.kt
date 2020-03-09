package com.github.sindicat.lab2.oop

import com.github.sindicat.lab2.oop.img.impl.MegaRandomSnowFlake
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
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
    HEIGHT, BufferedImage.TYPE_INT_RGB
)
private lateinit var graph: Graphics2D

fun main(args: Array<String>) {
    image = BufferedImage(
        WIDTH,
        HEIGHT, BufferedImage.TYPE_INT_RGB
    )
    graph = image.createGraphics()
    graph.color = Color.BLUE
    graph.fill(Rectangle2D.Double(0.0, 0.0, WIDTH.toDouble(), HEIGHT.toDouble()))
    MegaRandomSnowFlake(Color.GREEN,
        Color.ORANGE,
        Color.BLUE,
        graph,
        Point2D.Double(
            (WIDTH / 2).toDouble(),
            (HEIGHT / 2).toDouble()
        ),
        WIDTH / 3.toDouble(),
        6,
        3,
        4
    ).draw()
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