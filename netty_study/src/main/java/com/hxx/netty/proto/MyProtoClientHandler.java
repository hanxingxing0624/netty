package com.hxx.netty.proto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 一闪一闪亮晶晶丶
 * @Date：2019/11/18 10:47
 * @Version v1.0
 */
public class MyProtoClientHandler extends SimpleChannelInboundHandler<StudentProto.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentProto.Student msg) throws Exception {
        System.out.println("客户端连接成功");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        StudentProto.Student student = StudentProto.Student.newBuilder().setName("张三").setAge(18).
                setAddress("上海川沙").build();
        ctx.channel().writeAndFlush(student);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
