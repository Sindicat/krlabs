package com.github.sindicat.lab3.client.handler

import com.github.sindicat.lab3.dto.Message
import com.github.sindicat.lab3.utils.logProcessedMessage
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext

class ClientChannelHandler(private val clientName: String) : ChannelDuplexHandler() {

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        val processedMsg = msg as Message
        logProcessedMessage(processedMsg)
        processNextInput(ctx)
    }

    override fun channelActive(ctx: ChannelHandlerContext?) {
        val remoteAddress = ctx!!.channel().remoteAddress()
        println("Connected to the server: $remoteAddress")
        processNextInput(ctx)
        super.channelActive(ctx)
    }

    fun processNextInput(ctx: ChannelHandlerContext) {
        print("Enter message: ")
        val inputMsg = readLine() ?: ""
        ctx.writeAndFlush(Message(clientName, inputMsg))
    }
}