package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ServerIdleStateHandler extends IdleStateHandler {
    /**
     * 设置空闲检测时间为 30s
     */
    private static final int READER_IDLE_TIME = 10;
    public ServerIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {



        log.info("{} 秒内没有读取到数据,发送心跳包", READER_IDLE_TIME);
        byte commandCode = 0xA;  // 命令代码为 0xA
        String message = "come on baby!!!我是定时任务数据 [version:0xF5][seq:0xF8]";
        //byte[] data = message.getBytes();  // 将消息转换为字节数组作为数据域
        //System.out.println(data);
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        log.info("{} 数据:", data);
        ctx.writeAndFlush(new MyProtocolBean((byte) 0x18, (byte) 0x18, commandCode, data));
    }
}
