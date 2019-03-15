package Netty;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
    public static void main(String[] args) throws Exception
    {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>()
                {
                    @Override
                    protected void initChannel(SocketChannel arg0)
                    {
                        ChannelPipeline pipeline = arg0.pipeline();
                        pipeline.addLast((ChannelHandler) new ClientHandler());

                    }
                });
        ChannelFuture cf1 = b.connect("192.168.1.228",8082).sync();
        System.out.println("client start");
        cf1.channel().writeAndFlush(Unpooled.copiedBuffer("hello netty!".getBytes()));
        Thread.sleep(2000);
        cf1.channel().writeAndFlush(Unpooled.copiedBuffer("hello netty!!".getBytes()));
        Thread.sleep(2000);
        cf1.channel().writeAndFlush(Unpooled.copiedBuffer("hello netty!!!".getBytes()));
        group.shutdownGracefully();
    }

}
