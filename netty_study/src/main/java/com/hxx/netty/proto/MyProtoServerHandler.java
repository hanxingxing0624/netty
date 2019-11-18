package com.hxx.netty.proto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 一闪一闪亮晶晶丶
 * @Date：2019/11/18 10:38
 * @Version v1.0
 */
public class MyProtoServerHandler extends SimpleChannelInboundHandler<StudentProto.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentProto.Student msg) throws Exception {
        System.out.println(msg);
    }
}
