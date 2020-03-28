import com.github.sindicat.lab3.config.AppConfiguration
import com.github.sindicat.lab3.server.handler.init.ServerChannelInitializer
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.util.concurrent.DefaultThreadFactory


class Server(private val serverConfiguration: AppConfiguration) {

    private val bossGroup: EventLoopGroup = NioEventLoopGroup(1, DefaultThreadFactory("Netty-Boss-Pool"))

    private val workerGroup: EventLoopGroup = NioEventLoopGroup(1, DefaultThreadFactory("Netty-Worker-Pool"))

    fun start() {
        try {
            val serverBootstrap = ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel::class.java)
                .childHandler(ServerChannelInitializer(serverConfiguration.name))
                .localAddress(serverConfiguration.address)
            val future = serverBootstrap
                .bind()
                .sync()
            future.channel().closeFuture().sync()
        } finally {
            stop()
        }
    }

    fun stop() {
        workerGroup.shutdownGracefully()
        bossGroup.shutdownGracefully()
    }

}