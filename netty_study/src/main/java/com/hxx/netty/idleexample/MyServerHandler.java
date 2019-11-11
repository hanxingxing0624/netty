package com.hxx.netty.idleexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Author 一闪一闪亮晶晶丶
 * @Date：2019/11/8 15:47
 * @Version v1.0
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            IdleState state = event.state();
            String stateType = "";
            switch (state){
                case READER_IDLE:
                    stateType = "读空闲";
                    break;
                case WRITER_IDLE:
                    stateType = "写空闲";
                    break;
                case ALL_IDLE:
                    stateType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+stateType);
            ctx.close();
        }
    }
}
