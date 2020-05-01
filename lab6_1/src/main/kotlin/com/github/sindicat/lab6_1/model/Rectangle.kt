package com.github.sindicat.lab6_1.model

import kotlin.math.pow

class Rectangle(val length: Double?, val height: Double?) : Shape {

    override fun getArea(): Double? = if (length == null || height == null) null else length * height

    override fun getPerimeter(): Double? = if (length == null || height == null) null else length + height

    override fun getRadiusExternal(): Double? = if (length == null || height == null) null
    else ((length.pow(2) + height.pow(2)).pow(0.5)) / 2

    override fun getRadiusInternal(): Double? =  if (length == null || height == null) null
    else if (isSquare()) length / 2 else -1.0

    private fun isSquare(): Boolean =  if (length == null || height == null) false  else length.compareTo(height) == 0

}