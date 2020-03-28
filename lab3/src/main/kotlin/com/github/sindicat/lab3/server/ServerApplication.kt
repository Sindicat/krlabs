package com.github.sindicat.lab3.server

import Server
import com.github.sindicat.lab3.config.AppConfiguration

fun main(commandLineArgs: Array<String>) {
    val server = Server(AppConfiguration(commandLineArgs))
    Runtime.getRuntime().addShutdownHook( object : Thread() {
        override fun run() {
            server.stop()
        }
    })
    server.start()
}