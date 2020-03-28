package com.github.sindicat.lab3.client

import com.github.sindicat.lab3.config.AppConfiguration

fun main(commandLineArgs: Array<String>) {
    val client = Client(AppConfiguration(commandLineArgs))
    Runtime.getRuntime().addShutdownHook( object : Thread() {
        override fun run() {
            client.disconnect()
        }
    })
    client.connect()
}