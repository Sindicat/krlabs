//package com.github.sindicat.lab2.oop.img.impl
//
//import com.github.sindicat.lab2.oop.color.ColorResolver
//import java.awt.Color
//import java.awt.Graphics2D
//import java.awt.geom.Point2D
//import java.awt.image.BufferedImage
//
//class MegaRandomSnowFlake(
//    p: Point2D,
//    d: Double,
//    m: Int,
//    private val k: Int,
//    n: Int,
//    inColor: Color,
//    private val endColor: Color,
//    outColor: Color,
//    image: BufferedImage,
//    graph: Graphics2D
//) : RandomKochSnowflake(p, d, m, n, inColor, outColor, image, graph) {
//
//    private val colorResolver: ColorResolver = ColorResolver()
//
//    override fun draw() {
////        RandomKochSnowflake(p, d, m, n, endColor, outColor, image, graph).draw()
////        for (i in 1 until k) {
////            RandomKochSnowflake(
////                p,
////                d * (k - i) / k,
////                m,
////                n,
////                colorResolver.getBetweenColor(endColor, inColor, i.toDouble() / k),
////                colorResolver.getBetweenColor(endColor, inColor, (i - 1).toDouble() / k),
////                image,
////                graph
////            ).draw()
////        }
//    }
//}