package com.github.sindicat.lab3.handler

import io.netty.channel.Channel
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelPipeline
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.util.CharsetUtil

class AppChannelInitializer(vararg handlers: ChannelHandler) : ChannelInitializer<Channel>() {

    val customHandlers = handlers

    override fun initChannel(ch: Channel) {
        val pipeline: ChannelPipeline = ch.pipeline()
            .addLast("frameDecoder", LineBasedFrameDecoder(100))
            .addLast("stringDecoder", StringDecoder(CharsetUtil.UTF_8))
            .addLast("stringEncoder", StringEncoder(CharsetUtil.UTF_8))
            .addLast(*customHandlers)
    }

}