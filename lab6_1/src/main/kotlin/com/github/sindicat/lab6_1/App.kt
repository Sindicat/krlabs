package com.github.sindicat.lab6_1

import com.github.sindicat.lab6_1.views.MasterView
import tornadofx.*

fun main(args: Array<String>) {
    launch<MyApp>(args)
}

class MyApp: App(MasterView::class)

