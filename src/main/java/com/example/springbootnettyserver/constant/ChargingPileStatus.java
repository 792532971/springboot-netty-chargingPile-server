package com.example.springbootnettyserver.constant;

/**
 * @desc: 充电桩状态
 * @author: lt
 * @date: 2024/3/18 17:11
 */
public class ChargingPileStatus {
    /*
    管理状态 :
        充电桩由于维护或者程序升级等原因处于工作人员管理之中的状态，不能面向用户服务的状态
     */
    public static final int MANAGEMENT = 1;

    /*
    服务状态 :
        充电桩可进行充电服务的状态
     */
    public static final int SERVICE = 2;

    /*
    故障状态 :
        充电桩某功能单元发生故障时，充电桩上报的状态
     */
    public static final int FAULT = 3;

    /*
    初始化状态 :
        从“充电桩加电后进行初始化操作确认自身状态正常（比如
        检测充电桩各功能单元是否故障，不具备充电功率模块的充
        电桩还需检测对应充电机功能单元是否故障）”，到“与中心
        监控系统建立 TCP/IP 连接，完成上报签到信息”这段时间
        充电桩所处的状态
     */
    public static final int INITIALIZATION = 9;
}
