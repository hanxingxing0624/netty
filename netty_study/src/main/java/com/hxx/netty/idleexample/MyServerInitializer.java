package com.hxx.netty.idleexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Author 一闪一闪亮晶晶丶
 * @Date：2019/11/8 15:45
 * @Version v1.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(5,6,3,TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
