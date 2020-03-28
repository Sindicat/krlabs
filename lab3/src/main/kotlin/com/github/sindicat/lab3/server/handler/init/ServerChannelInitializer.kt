package com.github.sindicat.lab3.server.handler.init

import com.github.sindicat.lab3.handler.SerializationDeserializationHandler
import com.github.sindicat.lab3.server.handler.ServerChannelHandler
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.util.CharsetUtil

class ServerChannelInitializer(private val serverName: String) : ChannelInitializer<Channel>() {

    override fun initChannel(ch: Channel) {
        ch.pipeline()
            .addLast("frameDecoder", LineBasedFrameDecoder(100))
            .addLast("stringDecoder", StringDecoder(CharsetUtil.UTF_8))
            .addLast("stringEncoder", StringEncoder(CharsetUtil.UTF_8))
            .addLast("serializationDeserializationHandler", SerializationDeserializationHandler())
            .addLast("serverHandler", ServerChannelHandler(serverName))
    }

}