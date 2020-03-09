//package com.github.sindicat.lab2.oop.fratctal
//
//import com.github.sindicat.lab2.oop.img.impl.MegaRandomSnowFlake
//import java.awt.Color
//import java.awt.Graphics
//import java.awt.Graphics2D
//import java.awt.geom.Point2D
//import java.awt.geom.Rectangle2D
//import java.awt.image.BufferedImage
//import javax.swing.JFrame
//import javax.swing.JPanel
//
//internal const val WIDTH = 640
//
//internal const val HEIGHT = 480
//
//fun main(args: Array<String>) {
//    val image: BufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
//    var graph: Graphics2D = image.createGraphics().apply {
//        color = Color.BLUE
//        fill(Rectangle2D.Double(0.0, 0.0, WIDTH.toDouble(), HEIGHT.toDouble()))
//    }
//    val fractal = MegaRandomSnowFlake(
//        Point2D.Double(
//            (WIDTH / 2).toDouble(),
//            (HEIGHT / 2).toDouble()
//        ),
//        WIDTH / 3.toDouble(),
//        6,
//        3,
//        4,
//        Color.GREEN,
//        Color.ORANGE,
//        Color.BLUE,
//        image,
//        graph
//    )
//    fractal.draw()
//    val frame = JFrame()
//    frame.addNotify()
//    frame.setSize(
//        frame.insets.left + frame.insets.right + WIDTH,
//        frame.insets.top + frame.insets.bottom + HEIGHT
//    )
//    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
//    frame.add(object : JPanel() {
//        public override fun paintComponent(g: Graphics) {
//            val graphics = g as Graphics2D
//            graphics.drawImage(image, 0, 0, null)
//        }
//    })
//    frame.isVisible = true
//}