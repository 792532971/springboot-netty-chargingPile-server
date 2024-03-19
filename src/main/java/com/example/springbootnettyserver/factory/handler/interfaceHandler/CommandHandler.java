package com.example.springbootnettyserver.factory.handler.interfaceHandler;

import com.example.springbootnettyserver.pojo.MyProtocolBean;

/**
 * @author Administrator
 */
public interface CommandHandler {
    MyProtocolBean handle(MyProtocolBean message);
}
