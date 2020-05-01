package com.github.sindicat.lab6_1.dto

import com.github.sindicat.lab6_1.views.ShapeChoice

data class InputViewData(
    var length: String,
    var height: String,
    var aSide: String,
    var bSide: String,
    var cSide: String,
    var shapeChoice: ShapeChoice
)

data class OutputViewData(
    var area: String = "",
    var perimeter: String = "",
    var internalRadius: String = "",
    var externalRadius: String = "",
    var infoMsg: String = ""
)