package com.github.sindicat.lab3.config

import java.net.InetSocketAddress

private const val ADDRESS = "-address"
private const val PORT = "-port"
private const val NAME = "-name"
private const val DEFAULT_ADDRESS = "localhost"
private const val DEFAULT_PORT = 0
private const val DEFAULT_NAME = "unknown"

class AppConfiguration(commandLineArgs: Array<String>) {

    var address: InetSocketAddress? = null

    var name: String

    init {
        val argumentValueByKey: Map<String, String> = commandLineArgs
            .map {
                val splitedValue = it.split("=")
                splitedValue[0] to splitedValue[1]
            }.toMap()
        val host = (argumentValueByKey[ADDRESS] ?: DEFAULT_ADDRESS)
        val port = (argumentValueByKey[PORT]?.toInt() ?: DEFAULT_PORT)
        name = argumentValueByKey[NAME] ?: DEFAULT_NAME
        address = InetSocketAddress(host, port)
    }
}