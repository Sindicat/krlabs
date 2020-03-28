package com.github.sindicat.lab3.utils

import com.github.sindicat.lab3.dto.Message
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun logReceivedMessage(msg: Message) {
    println("${getFormattedCurrentTime()} - Received message from ${msg.sourceName}: \"${msg.payload}\"")
}

fun logProcessedMessage(msg: Message) {
    println("${getFormattedCurrentTime()} - Processed message from ${msg.sourceName}: \"${msg.payload}\"")
}

private fun getFormattedCurrentTime() = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)