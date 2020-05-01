package com.github.sindicat.lab6_1.controller

import com.github.sindicat.lab6_1.dto.InputViewData
import com.github.sindicat.lab6_1.dto.OutputViewData
import com.github.sindicat.lab6_1.model.Rectangle
import com.github.sindicat.lab6_1.model.Rhombus
import com.github.sindicat.lab6_1.model.Shape
import com.github.sindicat.lab6_1.model.Triangle
import com.github.sindicat.lab6_1.views.ShapeChoice

const val NOT_EXIST_MSG = "Не существует"

class MasterViewController {

    fun getUpdatedViewData(inputViewData: InputViewData): OutputViewData {
        if (inputViewData.shapeChoice == ShapeChoice.TRIANGLE
            && isTriangleNotExist(
                a = inputViewData.aSide.toDoubleOrNull(),
                b = inputViewData.bSide.toDoubleOrNull(),
                c = inputViewData.cSide.toDoubleOrNull()
            )
        ) {
            return OutputViewData(infoMsg = "Треугольника с заданными сторонами не существует!")
        }

        val shape: Shape = createShape(inputViewData)
        return createOutputViewData(shape)
    }

    private fun createShape(inputViewData: InputViewData): Shape {
        return when (inputViewData.shapeChoice) {
            ShapeChoice.RHOMBUS -> Rhombus(
                diagonalA = inputViewData.length.toDoubleOrNull(),
                diagonalB = inputViewData.height.toDoubleOrNull()
            )
            ShapeChoice.RECTANGLE -> Rectangle(
                length = inputViewData.length.toDoubleOrNull(),
                height = inputViewData.height.toDoubleOrNull()
            )
            ShapeChoice.TRIANGLE -> Triangle(
                a = inputViewData.aSide.toDoubleOrNull(),
                b = inputViewData.bSide.toDoubleOrNull(),
                c = inputViewData.cSide.toDoubleOrNull(),
                base = inputViewData.length.toDoubleOrNull(),
                height = inputViewData.height.toDoubleOrNull()
            )
        }
    }

    private fun createOutputViewData(shape: Shape): OutputViewData = OutputViewData().apply {
        area = shape.getArea()?.toString() ?: ""
        perimeter = shape.getPerimeter()?.toString() ?: ""
        internalRadius = shape.getRadiusInternal()?.let { getDecodedValue(it) } ?: ""
        externalRadius = shape.getRadiusExternal()?.let { getDecodedValue(it) } ?: ""
    }

    private fun getDecodedValue(value: Double): String = if (value == -1.0) NOT_EXIST_MSG else value.toString()

    private fun isTriangleNotExist(a: Double?, b: Double?, c: Double?): Boolean =
        if (a == null || b == null || c == null) false else !(a < b + c && b < a + c && c < a + b)
}