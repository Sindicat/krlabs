package com.github.sindicat.lab3.server.handler

import com.github.sindicat.lab3.dto.Message
import com.github.sindicat.lab3.utils.logProcessedMessage
import com.github.sindicat.lab3.utils.logReceivedMessage
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext

private const val NO_SPACE = ""

class ServerChannelHandler(private val serverName: String) : ChannelDuplexHandler() {

    private val chainOfSpacesRegexp = Regex("\\s+")

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any?) {
        processIncomingMsg(ctx, msg as Message)
    }

    private fun processIncomingMsg(ctx: ChannelHandlerContext, msg: Message) {
        logReceivedMessage(msg)
        val responsePayload: String = msg.payload
            .replace(chainOfSpacesRegexp, NO_SPACE)
            .toUpperCase()
        val responseMsg = Message(sourceName = serverName, payload = responsePayload)
        logProcessedMessage(responseMsg)
        ctx.writeAndFlush(responseMsg)
    }

    override fun channelActive(ctx: ChannelHandlerContext?) {
        val remoteAddress = ctx!!.channel().remoteAddress()
        println("New client connected from: $remoteAddress")
        super.channelActive(ctx)
    }
}