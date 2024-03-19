package com.example.springbootnettyserver.factory;

import com.example.springbootnettyserver.factory.handler.Command58Handler;
import com.example.springbootnettyserver.pojo.MyProtocolBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: lt
 * @date: 2024/3/18 14:23
 */
public class CommandHandlerFactory {

    private final Map<Byte, Class<? extends CommandHandler>> handlerMap;

    public CommandHandlerFactory() {
        this.handlerMap = new HashMap<>();
        // 注册命令代码和对应的处理逻辑类
        handlerMap.put((byte) 0x58, Command58Handler.class);
        // 如果有其他命令代码，可以继续注册
    }

    public CommandHandler createHandler(byte commandCode) throws IllegalAccessException, InstantiationException {
        Class<? extends CommandHandler> handlerClass = handlerMap.get(commandCode);
        if (handlerClass != null) {
            return handlerClass.newInstance();
        } else {
            throw new IllegalArgumentException("No handler found for commandCode: " + commandCode);
        }
    }

    public interface CommandHandler {
        MyProtocolBean handle(MyProtocolBean message);
    }



}
