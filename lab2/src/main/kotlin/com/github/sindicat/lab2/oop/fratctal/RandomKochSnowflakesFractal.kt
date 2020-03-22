package com.github.sindicat.lab2.oop.fratctal

import com.github.sindicat.lab2.oop.fratctal.elements.DrawableElement
import com.github.sindicat.lab2.oop.fratctal.elements.snowflake.MegaRandomKochSnowflake
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import javax.swing.JFrame
import javax.swing.JPanel


class RandomKochSnowflakesFractal(
    private val imageWidth: Int,
    private val imageHeight: Int,
    private val m: Int,
    private val k: Int,
    private val n: Int
) : DrawableElement {

    private val image = BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB)

    private val graph: Graphics2D = image.createGraphics().apply {
        color = Color.BLUE
        fill(Rectangle2D.Double(0.0, 0.0, imageWidth.toDouble(), imageHeight.toDouble()))
    }

    override fun draw() {
        MegaRandomKochSnowflake(
            Color.GREEN, Color.ORANGE, Color.BLUE, graph,
            Point2D.Double((imageWidth / 2).toDouble(), (imageHeight / 2).toDouble()),
            imageWidth / 3.toDouble(), m, k, n
        ).draw()
        showFractal()
    }

    private fun showFractal() = JFrame().apply {
        addNotify()
        setSize(
            insets.left + insets.right + imageWidth,
            insets.top + insets.bottom + imageHeight
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