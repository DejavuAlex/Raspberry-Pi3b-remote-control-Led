package Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class Server {
    public static void main(String[] args) throws Exception
    {
        EventLoopGroup pGroup = new NioEventLoopGroup();
        EventLoopGroup cGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(pGroup,cGroup)
                .channel(NioServerSocketChannel.class) //指定Nio模式
                .option(ChannelOption.SO_BACKLOG,1024)
                .option(ChannelOption.SO_SNDBUF,32*1024) //设置发送缓冲大小
                .option(ChannelOption.SO_RCVBUF,1024) //设置接收缓冲大小
                .childHandler(new ChannelInitializer<SocketChannel>()
                {
                    @Override
                    protected void initChannel(SocketChannel arg0)
                    {
                        ChannelPipeline pipeline = arg0.pipeline();
                        pipeline.addLast((ChannelHandler) new ServerHandler());

                    }
                });

        ChannelFuture cf1 = b.bind(8082).sync();
        System.out.println("server start");
        cf1.channel().closeFuture().sync();
        pGroup.shutdownGracefully();
        cGroup.shutdownGracefully();

    }

}
