package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import java.net.InetSocketAddress;

import com.example.springbootnettyserver.factory.CommandHandlerFactory;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @date 2020/11/26 11:40
 */
@Slf4j
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 管理一个全局map，保存连接进服务端的通道数量
     */
    private static final ConcurrentHashMap<ChannelId, ChannelHandlerContext> CHANNEL_MAP = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ChannelHandlerContext> CLIENT_MAP = new ConcurrentHashMap<>();


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //InetSocketAddress interSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        //System.out.println("已有客户端连接,端口为："+interSocket.getPort());
        //super.channelActive(ctx);
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();

        String clientIp = insocket.getAddress().getHostAddress();

        int clientPort = insocket.getPort();

        //获取连接通道唯一标识
        ChannelId channelId = ctx.channel().id();
        System.out.println(channelId);
        if (CLIENT_MAP.containsKey(clientIp)) {

            System.out.println("客户端【" + channelId + "】是连接状态，连接通道数量: " + CLIENT_MAP.size());


        } else {
            //保存连接
            CLIENT_MAP.put(clientIp, ctx);

            System.out.println("客户端【" + channelId + "】连接netty服务器[IP:" + clientIp + "--->PORT:" + clientPort + "]");
            //System.out.println("连接通道数量: " + CHANNEL_MAP.size());

        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try{
            if (msg instanceof MyProtocolBean){
                MyProtocolBean msg1 = (MyProtocolBean) msg;
                byte commandCode = ((MyProtocolBean) msg).getCommandCode();
                CommandHandlerFactory commandHandlerFactory = new CommandHandlerFactory();
                CommandHandlerFactory.CommandHandler handler = commandHandlerFactory.createHandler(commandCode);
                // 执行处理逻辑并获取返回值
                MyProtocolBean message = handler.handle(msg1);
                System.out.println(message.getSequenceNumber());


                //if (((MyProtocolBean) msg).getCommandCode() == (byte) 0x58) {
                //    // 在这里处理commandCode等于0x18的情况，例如打印日志
                //    System.out.println("commandCode is 0x58");
                //    // 可以在这里添加其他处理逻辑...
                //}

                /*
                System.out.println("收到客户端消息"+ ((MyProtocolBean) msg).getVersion());
                System.out.println("0x" + Integer.toHexString(((MyProtocolBean) msg).getCommandCode() & 0xFF));
                //Byte s = "0x" + Integer.toHexString(((MyProtocolBean) msg).getVersion() & 0xFF);
                System.out.println("123:::::"+new String(((MyProtocolBean) msg).getData(), StandardCharsets.UTF_8));
                String message = "这个是客户端的消息";
                byte[] data = message.getBytes();  // 将消息转换为字节数组作为数据域

                //MyProtocolBean bean = new MyProtocolBean((byte) 0x80, (byte) 1, commandCode, data);
                //ctx.writeAndFlush(bean);
                */

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将消息发送队列中的消息写入到SocketChannel中发送给对方
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //当发生异常时释放资源
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        try{
            InetSocketAddress inteSocket = (InetSocketAddress) ctx.channel().remoteAddress();
            System.out.println("已有客户端断开连接,端口为："+inteSocket.getPort());
            //super.channelInactive(ctx);

            InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();

            String clientIp = insocket.getAddress().getHostAddress();

            ChannelId channelId = ctx.channel().id();
            System.out.println(channelId);

            //包含此客户端才去删除
            if (CHANNEL_MAP.containsKey(channelId)) {
                //删除连接
                CHANNEL_MAP.remove(channelId);

                System.out.println("客户端【" + channelId + "】退出netty服务器[IP:" + clientIp + "--->PORT:" + insocket.getPort() + "]");
                // System.out.println("连接通道数量: " + CHANNEL_MAP.size());


            }else{
                System.out.println("你没存吧");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    /**
     * 获取客户端连接
     *
     * @param ip
     *            ip地址
     * @return
     */
    public static ChannelHandlerContext getClientConnection(String ip) {

        ChannelHandlerContext conn = CLIENT_MAP.get(ip);
        if (conn != null){
            return conn;
        }else {
//            logger.error("ClientConenction not found in allClientMap, ip = "
//                + ip + ", pileCode = " + pileCode);

            //System.out.println("ClientConenction not found in allClientMap, ip = "+ ip + ", pileCode = " + pileCode);

        }
        return null;
    }
}
