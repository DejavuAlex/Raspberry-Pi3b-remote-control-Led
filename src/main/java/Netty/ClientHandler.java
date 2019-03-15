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
import io.netty.util.ReferenceCountUtil;
import java.nio.channels.SocketChannel;

public class ClientHandler extends ChannelHandlerAdapter
{
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "utf-8");
            System.out.println("Client:" + body);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
        public void  exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
        {
            ctx.close();
        }
        public void channelActive(ChannelHandlerContext ctx)throws Exception
        {
            System.out.println("激活..");
        }
        public void channelReadComplete(ChannelHandlerContext ctx)throws Exception
       {
            System.out.println("完毕..");
        }
}

