package Netty;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.channels.SocketChannel;

public class ServerHandler extends ChannelHandlerAdapter
{

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req,"utf-8");
        System.out.println("Server:" + body);

        String response = "Hi Client!";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
    }
    public void  exceptionCaught(ChannelHandlerContext ctx, Throwable t) throws Exception
    {
        ctx.close();
    }
}
