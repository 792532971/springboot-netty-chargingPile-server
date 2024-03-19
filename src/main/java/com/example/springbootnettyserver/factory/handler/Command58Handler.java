package com.example.springbootnettyserver.factory.handler;


import com.example.springbootnettyserver.factory.CommandHandlerFactory.CommandHandler;
import com.example.springbootnettyserver.pojo.MyProtocolBean;
/**
 * @desc:  远端心跳包信息上报
 * @author:
 * @date: 2024/3/18 0018 14:39
 */
public class Command58Handler implements CommandHandler {

    @Override
    public MyProtocolBean handle(MyProtocolBean request) {
        // 处理命令代码为 0x58 的业务逻辑
        System.out.println(request.getCommandCode());
        System.out.println("0x" + Integer.toHexString(request.getCommandCode() & 0xFF));
        request.setData("Modified data".getBytes());
        return request;
    }
}
