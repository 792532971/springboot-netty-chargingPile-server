package com.example.springbootnettyserver.mapper;


import java.util.HashMap;
import java.util.Map;


import io.netty.channel.ChannelHandlerContext;
/**
 * @desc:
 * @author: Administrator
 * @date: 2024/3/16 0016 18:51
 */
public class ClientConnection {
    //private static final Logger logger = LogManager.getLogger(ClientConnection.class);


    /**
     * 记录超时时间用
     */
    private long lastTime;

    private ChannelHandlerContext ctx;
    private String id;
    private String port;
    /**
     * 桩编号/集中器编号
     */
    private String pile_code;

    private boolean isFirst = true;
    /**
     * 刷卡启动
     */
    private boolean isSwpCad  = false;

    private String userID;

    /**
     * 集中器下桩地址
     */
    private int pileNum;

    /**
     * 集中器下桩 充电状态信息
     */
    private Map<Integer, Integer> val = new HashMap<Integer, Integer>();



    /**
     * 盛宏 桩当前 工作状态 </br>
     *  0‐空闲中 1‐正准备开始充电 2‐充电进行中 3‐充电结束 4‐启动失败 5‐预约状 态 6‐系统故障(不能给汽车充 电)
     *
     */
    public static final int STATE_NORMAL        = 0;
    public static final int STATE_READY         = 1;
    public static final int STATE_CHARGE        = 2;
    public static final int STATE_CHARGE_OVER   = 3;

    /**
     *  4‐失败
     */
    public static final int STATE_START_FAILED   = 4;

    public static final int STATE_ORDER          = 5;
    /**
     * 故障，告警
     */
    public static final int STATE_TROUBLE        = 6;
    /**
     * 离线，无法进行通信
     */
    public static final int STATE_OFF_LINE       = 7;


    /**
     *
     *
     * 桩当前状态 0-正常 1-预约中 2-充电中 3-离线  6-故障
     */
    private int pileState;


    ClientConnection(String ip, ChannelHandlerContext c) {
        this.id = ip;
        ctx = c;
        pileState = STATE_NORMAL;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }

        if (obj == null){
            return false;

        }
        if (getClass() != obj.getClass()){

            return false;
        }
        ClientConnection other = (ClientConnection) obj;
        if (id == null) {
            if (other.id != null){

                return false;
            }
        } else if (!id.equals(other.id)){
            return false;

        }
        return true;
    }


}
