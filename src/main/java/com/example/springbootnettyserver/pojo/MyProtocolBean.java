package com.example.springbootnettyserver.pojo;

import lombok.Data;

@Data
public class MyProtocolBean {
    private static final byte START_BYTE_1 = (byte) 0xFA;
    private static final byte START_BYTE_2 = (byte) 0xF5;

    private byte version; //版本域
    private byte sequenceNumber;  //序列号
    private byte commandCode;   //命令码
    private byte[] data; //数据域
    private byte checksum; //校验和
    private byte length; //校验和

    // 构造方法
    public MyProtocolBean(byte version, byte sequenceNumber, byte commandCode, byte[] data) {
        this.version = version;
        this.sequenceNumber = sequenceNumber;
        this.commandCode = commandCode;
        this.data = data;
        this.checksum = calculateChecksum();
        this.length =calculateLength();
    }

    private byte calculateLength() {
        // 长度域 = 长度域本身的长度（1 Byte） + 版本域的长度（1 Byte） + 序列号域的长度（1 Byte）
        //            + 命令代码的长度（1 Byte） + 数据域的长度 + 校验和域的长度（1 Byte）
        return (byte) (5 + data.length);
    }

    // 计算校验和
    private byte calculateChecksum() {
        int sum = version + sequenceNumber + commandCode;
        for (byte b : data) {
            sum += b;
        }
        return (byte) sum;
    }

    // 生成协议报文的字节数组
    public byte[] toByteArray() {
        byte[] byteArray = new byte[4 + data.length]; // 4 是起始域、版本域、序列号域和命令代码的长度

        byteArray[0] = START_BYTE_1;
        byteArray[1] = START_BYTE_2;
        byteArray[2] = length;
        byteArray[3] = version;
        byteArray[4] = sequenceNumber;
        byteArray[5] = commandCode;
        System.arraycopy(data, 0, byteArray, 6, data.length); // 将数据域拷贝到字节数组中
        byteArray[length - 1] = checksum;

        return byteArray;
    }


}