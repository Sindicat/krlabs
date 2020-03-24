import com.github.sindicat.lab3.config.AppConfiguration
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.EventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel


class Server(private val serverConfiguration: AppConfiguration) {

    private val bossGroup: EventLoopGroup? = null

    private val workerGroup: EventLoopGroup? = null

    fun start() {
        val serverBootstrap = ServerBootstrap()
        serverBootstrap.group(bossGroup, workerGroup)
        serverBootstrap.channel(NioServerSocketChannel::class.java)
        serverBootstrap.childHandler(channelInitializer)
        serverBootstrap.localAddress(serverConfiguration.address)
        serverBootstrap.childAttr(NDC_SERVER_ATTRIBUTE_KEY, ndcServer)
    }

}