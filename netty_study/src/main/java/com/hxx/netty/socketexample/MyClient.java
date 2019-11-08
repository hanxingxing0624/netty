package com.hxx.netty.socketexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author 一闪一闪亮晶晶丶
 * @Date：2019/11/7 16:11
 * @Version v1.0
 */
public class MyClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
                    handler(new MyClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8099).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
