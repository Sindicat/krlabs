package com.github.sindicat.lab6_1.views

import com.github.sindicat.lab6_1.controller.MasterViewController
import com.github.sindicat.lab6_1.dto.InputViewData
import com.github.sindicat.lab6_1.dto.OutputViewData
import javafx.collections.FXCollections
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import tornadofx.View


class MasterView : View() {
    override val root: BorderPane by fxml(location = "MasterView.fxml")

    val area: TextField by fxid()
    val perimeter: TextField by fxid()
    val inRadius: TextField by fxid()
    val outRadius: TextField by fxid()
    val length: TextField by fxid()
    val height: TextField by fxid()
    private val aSide: TextField by fxid()
    private val bSide: TextField by fxid()
    private val cSide: TextField by fxid()
    private val angle: TextField by fxid()
    private val aSideLabel: Label by fxid()
    private val bSideLabel: Label by fxid()
    private val cSideLabel: Label by fxid()
    private val lengthLabel: Label by fxid()
    private val heightLabel: Label by fxid()
    private val infoLabel: Label by fxid()
    private val angleLabel: Label by fxid()

    val shapeSelector: ChoiceBox<ShapeChoice> by fxid()

    val masterViewController: MasterViewController = MasterViewController()

    init {
        val choices = FXCollections.observableArrayList<ShapeChoice>()
        choices.add(ShapeChoice.RECTANGLE)
        choices.add(ShapeChoice.RHOMBUS)
        choices.add(ShapeChoice.TRIANGLE)
        shapeSelector.items = choices
        shapeSelector.value = ShapeChoice.TRIANGLE
        setNameForLabels("Основание: ", "Высота: ")

        shapeSelector.selectionModel.selectedItemProperty().addListener { _, _, newValue: ShapeChoice ->
            updatedFormWithCalculatedMeasures(OutputViewData())
            when (newValue) {
                ShapeChoice.TRIANGLE -> {
                    setVisibilityTriangleSpecificInputs(isVisible = true)
                    aSideLabel.text = "Сторона А: "
                    angleLabel.isVisible = true
                    angle.isVisible = true
                    angleLabel.text = "Угол между сторонами A и В: "
                    setNameForLabels("Основание: ", "Высота: ")
                }
                ShapeChoice.RECTANGLE -> {
                    setVisibilityTriangleSpecificInputs(isVisible = false)
                    angleLabel.isVisible = false
                    angle.isVisible = false
                    setNameForLabels("Длина: ", "Ширина: ")
                }
                ShapeChoice.RHOMBUS -> {
                    setVisibilityTriangleSpecificInputs(isVisible = false)
                    aSide.isVisible = true
                    aSideLabel.isVisible = true
                    aSideLabel.text = "Сторона ромба: "
                    angleLabel.isVisible = true
                    angleLabel.text = "Угол между сторонами: "
                    angle.isVisible = true
                    setNameForLabels("Первая диагональ: ", "Вторая диагональ: ")
                }
            }
        }
    }

    private fun setVisibilityTriangleSpecificInputs(isVisible: Boolean) {
        aSide.isVisible = isVisible
        bSide.isVisible = isVisible
        cSide.isVisible = isVisible
        aSideLabel.isVisible = isVisible
        bSideLabel.isVisible = isVisible
        cSideLabel.isVisible = isVisible
    }

    private fun setNameForLabels(lengthLabelName: String, heightLabelName: String) {
        lengthLabel.text = lengthLabelName
        heightLabel.text = heightLabelName
    }

    fun onCalculateButtonPressed() {
        val outputViewData: OutputViewData = masterViewController.getUpdatedViewData(
            InputViewData(
                length = length.text,
                height = height.text,
                aSide = aSide.text,
                bSide = bSide.text,
                cSide = cSide.text,
                angle = angle.text,
                shapeChoice = shapeSelector.value
            )
        )
        updatedFormWithCalculatedMeasures(outputViewData)
    }

    private fun updatedFormWithCalculatedMeasures(outputViewData: OutputViewData) {
        area.text = outputViewData.area
        perimeter.text = outputViewData.perimeter
        inRadius.text = outputViewData.internalRadius
        outRadius.text = outputViewData.externalRadius
        infoLabel.text = outputViewData.infoMsg
    }
}

enum class ShapeChoice(private var shapeName: String) {
    RHOMBUS("Ромб"),
    TRIANGLE("Треугольник"),
    RECTANGLE("Прямоугольник");

    override fun toString(): String = shapeName
}