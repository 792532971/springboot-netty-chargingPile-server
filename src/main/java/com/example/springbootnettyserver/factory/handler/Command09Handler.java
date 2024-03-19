package com.example.springbootnettyserver.factory.handler;


import com.example.springbootnettyserver.factory.CommandHandlerFactory.CommandHandler;
import com.example.springbootnettyserver.pojo.MyProtocolBean;

/**
 * @desc: 中心系统在接收到充电桩签到命令后应答
 * @author:
 * @date: 2024/3/18 0018 14:39
 */
public class Command09Handler implements CommandHandler {

    @Override
    public MyProtocolBean handle(MyProtocolBean request) {
        // 处理命令代码为 0x58 的业务逻辑
        //System.out.println(request.getCommandCode());
        //System.out.println("0x" + Integer.toHexString(request.getCommandCode() & 0xFF));
        request.setVersion((byte) 0x80);
        request.setCommandCode((byte) 0x09);
        request.setSequenceNumber((byte) 0x09);
        request.setData("Modified data".getBytes());
        return request;
    }
}
