package com.github.sindicat.lab3.handler

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.sindicat.lab3.dto.Message
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise

private const val END_OF_MSG = "\n"

class SerializationDeserializationHandler : ChannelDuplexHandler() {

    private val objectMapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        ctx.fireChannelRead(objectMapper.readValue(msg as String, Message::class.java))
    }

    override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise?) {
        super.write(ctx, objectMapper.writeValueAsString(msg) + END_OF_MSG, promise)
    }
}