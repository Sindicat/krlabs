package com.github.sindicat.lab3.client

import com.github.sindicat.lab3.client.handler.init.ClientChannelInitializer
import com.github.sindicat.lab3.config.AppConfiguration
import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel

class Client(private val clientConfiguration: AppConfiguration) {

    private val workerGroup: EventLoopGroup = NioEventLoopGroup(1)

    fun connect() {
        try {
            val clientBootstrap: Bootstrap = Bootstrap()
                .group(workerGroup)
                .channel(NioSocketChannel::class.java)
                .handler(ClientChannelInitializer(clientConfiguration.name))
            val future = clientBootstrap
                .connect(clientConfiguration.address)
                .sync()
            future.channel().closeFuture().sync()
        } finally {
            disconnect()
        }
    }

    fun disconnect() {
        workerGroup.shutdownGracefully()
    }
}