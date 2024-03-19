package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyProtocolDecoder extends ByteToMessageDecoder {
    private static final int START_FIELD_LENGTH = 2; // 起始域长度
    private static final byte[] START_FIELD = { (byte) 0xFA, (byte) 0xF5 }; // 起始域固定值


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            if (in.readableBytes() < START_FIELD_LENGTH) {
                return; // 等待更多的数据以检查起始域
            }

            byte[] receivedStartField = new byte[START_FIELD_LENGTH];
            in.readBytes(receivedStartField);
            if (!java.util.Arrays.equals(START_FIELD, receivedStartField)) {
                throw new IllegalStateException("Invalid start field");
            }

            if (in.readableBytes() < 5) { // 至少需要读取长度域(1 Byte) + 版本域(1 Byte) + 序列号域(1 Byte) + 命令代码(1 Byte)
                return;
            }
            //if (receivedStartField[3] == (byte) 0x18) {
            //}

            int length = in.readByte() & 0xFF; // 读取长度域（1 Byte），注意无符号处理
            if (!(receivedStartField[0] == (byte) 0xFA && receivedStartField[1] == (byte) 0xF5)) {// 至少包含命令代码(1 Byte)和校验和(1 Byte)
                throw new IllegalStateException("Invalid length field");
            }

            byte version = in.readByte(); // 读取版本域
            byte sequence = in.readByte(); // 读取序列号域
            byte commandCode = in.readByte(); // 读取命令代码
            //if (commandCode == (byte) 0x58) {
            //    // 在这里处理commandCode等于0x18的情况，例如打印日志
            //    System.out.println("commandCode is 0x58");
            //    // 可以在这里添加其他处理逻辑...
            //}

            if (in.readableBytes() < length - 3) { // 减去已经读取的字段，检查剩余数据长度
                return;
            }

            byte[] data = new byte[length - 3]; // 数据域长度 = 总长度 - 3（长度域、版本域、序列号域）
            in.readBytes(data); // 读取数据域


            byte checksum = calculateChecksum(commandCode, data); // 计算校验和
            byte receivedChecksum = in.readByte(); // 读取校验和域

            if (checksum != receivedChecksum) {
                throw new IllegalStateException("Invalid checksum");
            }
            // 创建自定义的消息对象来封装解码后的数据，并添加到输出列表中
            // 这里假设你有一个 ChargingStationMessage 类来封装这些信息
            MyProtocolBean message = new MyProtocolBean(version, sequence, commandCode, data);
            out.add(message);
        } catch (Exception e) {
            // 处理异常
            System.out.println(e.getMessage());
            // 您可以记录异常、关闭连接等
            ctx.close(); // 关闭通道作为错误处理的例子
        }



    }
    //这里commandCode我需要根据不同的命令代码处理不同的业务,应该怎么做好一点 ,万一有几十上百个if那肯定不行,请问有什么好的办法,如果有好的方法
    //        给我个demo

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