package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyProtocolEncoder extends MessageToByteEncoder<MyProtocolBean> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MyProtocolBean msg, ByteBuf out) throws Exception {
        if(msg == null){
            throw new Exception("msg is null");
        }
        out.writeByte(0xFA);
        out.writeByte(0xF5);

        // 写入长度域（不包含起始域和校验和域）
        int dataLength = msg.getData().length + 3; // 数据域长度 + 版本域 + 序列号域 + 命令代码
        out.writeByte(dataLength);

        // 写入版本域
        out.writeByte(msg.getVersion());

        // 写入序列号域
        out.writeByte(msg.getSequenceNumber());

        // 写入命令代码
        out.writeByte(msg.getCommandCode());
        out.writeBytes(msg.getData());

        // 计算校验和并写入校验和域
        byte checksum = calculateChecksum(msg.getCommandCode(), msg.getData());
        out.writeByte(checksum);

    }

    private byte calculateChecksum(byte commandCode, byte[] data) {
        // 实现校验和的计算逻辑，这里只是示例，具体实现取决于协议中的定义
        int checksum = 0;
        checksum += commandCode & 0xFF; // 注意无符号处理
        for (byte b : data) {
            checksum += b & 0xFF; // 注意无符号处理
        }
        return (byte) (checksum & 0xFF); // 返回校验和的低8位
    }
}