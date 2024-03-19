package com.example.springbootnettyserver.constant;

/**
 * @desc: 命令代码
 * @author: lt
 * @date: 2024/3/18 0018 15:40
 */
public class CommandConstant {
    // 1. 充电桩 参数设置 中心系统 充电桩 0x41
    public static final byte COMMAND_0x41 = 0x41;

    // 2. 充电桩 参数设置应答 充电桩 中心系统 0x51
    public static final byte COMMAND_0x51 = 0x51;

    // 3. 充电桩 时间同步 中心系统 充电桩 0x42
    public static final byte COMMAND_0x42 = 0x42;

    // 4. 充电桩 时间同步应答 充电桩 中心系统 0x52
    public static final byte COMMAND_0x52 = 0x52;

    // 5. 充电桩 工作参数设置 中心系统 充电桩 0x46
    public static final byte COMMAND_0x46 = 0x46;

    // 6. 充电桩 工作参数设置应答 充电桩 中心系统 0x56
    public static final byte COMMAND_0x56 = 0x56;

    // 7. 充电桩 本地 IP 参数设置 中心系统 充电桩 0x47
    public static final byte COMMAND_0x47 = 0x47;

    // 8. 充电桩 本地 IP 参数设置应答 充电桩 中心系统 0x57
    public static final byte COMMAND_0x57 = 0x57;

    // 9. 服务器系统心跳包信息应答 中心系统 充电桩 0x48
    public static final byte COMMAND_0x48 = 0x48;

    // 10. 远端心跳包信息上报 充电桩 中心系统 0x58
    public static final byte COMMAND_0x58 = 0x58;

    // 11. 系统心跳包信息参数设置 中心系统 充电桩 0x49
    public static final byte COMMAND_0x49 = 0x49;

    // 12. 系统心跳包信息参数设置应答 充电桩 中心系统 0x59
    public static final byte COMMAND_0x59 = 0x59;

    // 13. 系统刷卡流程信息参数设置 中心系统 充电桩 0x40
    public static final byte COMMAND_0x40 = 0x40;

    // 14. 系统刷卡流程信息参数设置应答 充电桩 中心系统 0x50
    public static final byte COMMAND_0x50 = 0x50;

    // 15. 充电桩 重启设置 中心系统 充电桩 0x43
    public static final byte COMMAND_0x43 = 0x43;

    // 16. 充电桩 重启设置应答 充电桩 中心系统 0x53
    public static final byte COMMAND_0x53 = 0x53;

    // 17. 密钥卡信息配置 中心系统 充电桩 0x44
    public static final byte COMMAND_0x44 = 0x44;

    // 18. 密钥卡信息配置应答 充电桩 中心系统 0x54
    public static final byte COMMAND_0x54 = 0x54;

    // 19. 中心系统下达签到查询命令 中心系统 充电桩 0x01
    public static final byte COMMAND_0x01 = 0x01;

    // 20. 中心系统查询签到应答/上报 充电桩 中心系统 0x10
    public static final byte COMMAND_0x10 = 0x10;

    // 21. 中心系统答复签到命令 中心系统 充电桩 0x09
    public static final byte COMMAND_0x09 = 0x09;

    // 22. 中心下达充电桩远程运营参数控制设置 中心系统 充电桩 0x0A
    public static final byte COMMAND_0x0A = 0x0A;

    // 23. 充电桩应答远程运营参数设置应答 充电桩 中心系统 0x1A
    public static final byte COMMAND_0x1A = 0x1A;

    // 24. 中心系统下达状态查询命令 中心系统 充电桩 0x02
    public static final byte COMMAND_0x02 = 0x02;

    // 25. 充电桩 状态上报 充电桩 中心系统 0x11
    public static final byte COMMAND_0x11 = 0x11;

    // 26. 充电桩远程控制设置 中心系统 充电桩 0x05
    public static final byte COMMAND_0x05 = 0x05;

    // 27. 充电桩远程控制应答 充电桩 中心系统 0x15
    public static final byte COMMAND_0x15 = 0x15;

    // 28. 当前充电模块参数信息查询 中心系统 充电桩 0x07
    public static final byte COMMAND_0x07 = 0x07;

    // 29. 当前充电模块参数查询应答/上报 充电桩 中心系统 0x17
    public static final byte COMMAND_0x17 = 0x17;

    // 30. 当前充电电池模块参数信息查询 中心系统 充电桩 0x08
    public static final byte COMMAND_0x08 = 0x08;

    // 31. 当前充电电池模块参数信息查询应答/上报 充电桩 中心系统 0x18
    public static final byte COMMAND_0x18 = 0x18;

    // 32. 通信模式设置命令 中心系统 充电桩 0xE0
    public static final byte COMMAND_0xE0 = (byte)0xE0;

    // 33. 通信模式设置命令应答 充电桩 中心系统 0xF0
    public static final byte COMMAND_0xF0 = (byte)0xF0;

    // 34. 当前充电桩总体状态查询 中心系统 充电桩 0x21
    public static final byte COMMAND_0x21 = 0x21;

    // 35. 当前充电桩总体状态应答/上报 充电桩 中心系统 0x31
    public static final byte COMMAND_0x31 = 0x31;

    // 36. 当前充电模块电池信息查询 中心系统 充电桩 0x22
    public static final byte COMMAND_0x22 = 0x22;

    // 37. 当前充电模块电池信息查询应答/上报 充电桩 中心系统 0x3A
    public static final byte COMMAND_0x3A = 0x3A;

    // 38. 当前充电模块充电信息查询 中心系统 充电桩 0x23
    public static final byte COMMAND_0x23 = 0x23;

    // 39. 当前充电模块充电查询应答/上报 充电桩 中心系统 0x39
    public static final byte COMMAND_0x39 = 0x39;

    // 40. 当前充电模块状态信息查询 中心系统 充电桩 0x24
    public static final byte COMMAND_0x24 = 0x24;

    // 41. 当前充电模块状态信息查询应答/上报 充电桩 中心系统 0x34
    public static final byte COMMAND_0x34 = 0x34;

    // 42. 当前电池系统故障状态信息查询 中心系统 充电桩 0x25
    public static final byte COMMAND_0x25 = 0x25;

    // 43. 当前电池系统故障状态查询应答/上报 充电桩 中心系统 0x35
    public static final byte COMMAND_0x35 = 0x35;

    // 44. 当前电池单体信息查询 中心系统 充电桩 0x26
    public static final byte COMMAND_0x26 = 0x26;

    // 45. 当前电池单体信息查询应答/上报 充电桩 中心系统 0x36
    public static final byte COMMAND_0x36 = 0x36;

    // 46. 当前充电桩配电信息查询 中心系统 充电桩 0x2B
    public static final byte COMMAND_0x2B = 0x2B;

    // 47. 当前充电桩配电信息查询应答/上报 充电桩 中心系统 0x3B
    public static final byte COMMAND_0x3B = 0x3B;

    // 48. 当前充电桩电表信息查询 中心系统 充电桩 0x2C
    public static final byte COMMAND_0x2C = 0x2C;

    // 49. 当前充电桩电表信息查询应答/上报 充电桩 中心系统 0x3C
    public static final byte COMMAND_0x3C = 0x3C;

    // 50. 充电桩 上报账户查询命令 充电桩 中心系统 0x70
    public static final byte COMMAND_0x70 = 0x70;

    // 51. 中心系统应答账户查询 中心系统 充电桩 0x69
    public static final byte COMMAND_0x69 = 0x69;

    // 52. 充电桩 上报服务类型申请命令 充电桩 中心系统 0x71
    public static final byte COMMAND_0x71 = 0x71;

    // 53. 中心系统应答服务类型命令 中心系统 充电桩 0x61
    public static final byte COMMAND_0x61 = 0x61;

    // 54. 充电桩 上报电池认证查询命令 充电桩 中心系统 0x72
    public static final byte COMMAND_0x72 = 0x72;

    // 55. 中心系统应答电池认证查询 中心系统 充电桩 0x62
    public static final byte COMMAND_0x62 = 0x62;

    // 56. 充电桩 上报充电记录命令 充电桩 中心系统 0x79
    public static final byte COMMAND_0x79 = 0x79;

    // 57. 中心系统应答充电记录上报 中心系统 充电桩 0x68
    public static final byte COMMAND_0x68 = 0x68;

    // 58. 充电桩 查询充电记录命令 充电桩 中心系统 0x74
    public static final byte COMMAND_0x74 = 0x74;

    // 59. 中心系统应答查询充电记录 中心系统 充电桩 0x64
    public static final byte COMMAND_0x64 = 0x64;

    // 60. 充电桩 上报车牌认证查询命令 充电桩 中心系统 0x75
    public static final byte COMMAND_0x75 = 0x75;

    // 61. 中心系统应答车牌认证查询 中心系统 充电桩 0x65
    public static final byte COMMAND_0x65 = 0x65;

    // 62. 充电桩应答中心合法用户认证通过信息命令 充电桩 中心系统 0x7A
    public static final byte COMMAND_0x7A = 0x7A;

    // 63. 中心系统下达合法用户认证通过信息 中心系统 充电桩 0x6C
    public static final byte COMMAND_0x6C = 0x6C;

    // 64. 充电桩应答中心服务类别认证信息命令 充电桩 中心系统 0x7B
    public static final byte COMMAND_0x7B = 0x7B;

    // 65. 中心系统下达服务类别认证通过信息 中心系统 充电桩 0x6B
    public static final byte COMMAND_0x6B = 0x6B;

    // 66. 充电桩智能终端上报修改充电卡支付密码命令 充电桩 中心系统 0x7E
    public static final byte COMMAND_0x7E = 0x7E;

    // 67. 中心系统应答修改充电卡支付密码请求 中心系统 充电桩 0x6E
    public static final byte COMMAND_0x6E = 0x6E;

    // 68. 充电桩智能终端查询充电卡余额命令 充电桩 中心系统 0x76
    public static final byte COMMAND_0x76 = 0x76;

    // 69. 中心系统应答查询充电卡余额命令 中心系统 充电桩 0x66
    public static final byte COMMAND_0x66 = 0x66;

    // 70. 查询充电桩历史充电记录命令 中心系统 充电桩 0x80
    public static final byte COMMAND_0x80 = (byte)0x80;

    // 71. 查询充电桩历史充电记录命令应答 充电桩 中心系统 0x93
    public static final byte COMMAND_0x93 = (byte)0x93;

    // 72. 查询充电桩历史事件记录命令 中心系统 充电桩 0x86
    public static final byte COMMAND_0x86 = (byte)0x86;

    // 73. 查询充电桩历史事件记录命令应答 充电桩 中心系统 0x96
    public static final byte COMMAND_0x96 = (byte)0x96;

    // 74. 查询充电桩历史告警记录命令 中心系统 充电桩 0x87
    public static final byte COMMAND_0x87 = (byte)0x87;

    // 75. 查询充电桩历史告警记录命令应答 充电桩 中心系统 0x97
    public static final byte COMMAND_0x97 = (byte)0x97;

    // 76. 查询充电桩历史充电过程记录命令 中心系统 充电桩 0x88
    public static final byte COMMAND_0x88 = (byte)0x88;

    // 77. 查询充电桩历史充电过程记录命令应答 充电桩 中心系统 0x98
    public static final byte COMMAND_0x98 = (byte)0x98;

    // 78. 数据管理操作命令 中心系统 充电桩 0xE1
    public static final byte COMMAND_0xE1 = (byte)0xE1;

    // 79. 数据管理操作命令应答 充电桩 中心系统 0xF1
    public static final byte COMMAND_0xF1 = (byte)0xF1;

    // 80. 数据管理模式命令 中心系统 充电桩 0xE2
    public static final byte COMMAND_0xE2 = (byte)0xE2;

    // 81. 数据管理模式命令应答 充电桩 中心系统 0xF2
    public static final byte COMMAND_0xF2 = (byte)0xF2;

    // 82. 系统向充电桩下达充电预约操作命令 中心系统 充电桩 0xC1
    public static final byte COMMAND_0xC1 = (byte)0xC1;

    // 83. 充电桩向系统下达充电预约操作应答 充电桩 中心系统 0xD1
    public static final byte COMMAND_0xD1 = (byte)0xD1;

    // 84. 系统向充电桩下达充电预约查询命令 中心系统 充电桩 0xC2
    public static final byte COMMAND_0xC2 = (byte)0xC2;

    // 85. 充电桩向系统下达充电预约查询应答 充电桩 中心系统 0xD2
    public static final byte COMMAND_0xD2 = (byte)0xD2;

    // 86. 系统向充电桩下达充电车位数据查询命令 中心系统 充电桩 0xC3
    public static final byte COMMAND_0xC3 = (byte)0xC3;

    // 87. 充电桩向系统下达充电车位数据查询应答 充电桩 中心系统 0xD3
    public static final byte COMMAND_0xD3 = (byte)0xD3;

    // 88. 充电桩向系统下达充电预约取消命令 充电桩 中心系统 0xD4
    public static final byte COMMAND_0xD4 = (byte)0xD4;

    // 89. 系统向充电桩回复充电预约取消命令 中心系统 充电桩 0xC4
    public static final byte COMMAND_0xC4 = (byte)0xC4;

    // 90. 系统下达读取充电桩参数命令 中心系统 充电桩 0xEA
    public static final byte COMMAND_0xEA = (byte)0xEA;

    // 91. 充电桩回复系统读取充电桩参数命令 充电桩 中心系统 0xFA
    public static final byte COMMAND_0xFA = (byte)0xFA;

    // 92. 中心系统远程配置充电桩参数命令 中心系统 充电桩 0xEB
    public static final byte COMMAND_0xEB = (byte)0xEB;

    // 93. 中心系统远程配置充电桩参数应答 充电桩 中心系统 0xFB
    public static final byte COMMAND_0xFB = (byte)0xFB;

    // 94. 系统下达读取充电桩电源模块读取电源工作参数命令 中心系统 充电桩 0xEC
    public static final byte COMMAND_0xEC = (byte)0xEC;

    // 95. 系统下达读取充电桩电源模块读取电源工作参数应答 充电桩 中心系统 0xFC
    public static final byte COMMAND_0xFC = (byte)0xFC;

    // 96. 查询充电桩固件版本信息查询命令 中心系统 充电桩 0xA0
    public static final byte COMMAND_0xA0 = (byte)0xA0;

    // 97. 查询充电桩固件版本信息命令应答 充电桩 中心系统 0xB0
    public static final byte COMMAND_0xB0 = (byte)0xB0;

    // 98. 下载充电桩固件程序命令 中心系统 充电桩 0xA1
    public static final byte COMMAND_0xA1 = (byte)0xA1;

    // 99. 下载充电桩固件程序命令应答 充电桩 中心系统 0xB1
    public static final byte COMMAND_0xB1 = (byte)0xB1;

    // 100. 升级充电桩固件程序命令 中心系统 充电桩 0xA2
    public static final byte COMMAND_0xA2 = (byte)0xA2;

    // 101. 升级充电桩固件程序命令应答 充电桩 中心系统 0xB2
    public static final byte COMMAND_0xB2 = (byte)0xB2;

    // 102. 充电桩上报电池温度保护告警信息 充电桩 中心系统 0x73
    public static final byte COMMAND_0x73 = (byte)0x73;

    // 103. 中心系统应答电池温度保护告警信息 充电桩 中心系统 0x63
    public static final byte COMMAND_0x63 = (byte)0x63;

    // 104. 充电桩上报电池温度告警恢复信息 充电桩 中心系统 0x78
    public static final byte COMMAND_0x78 = (byte)0x78;

    // 105. 中心系统应答电池温度告警恢复信息 充电桩 中心系统 0x67
    public static final byte COMMAND_0x67 = (byte)0x67;

    // 106. 充电桩上报智能终端插拔信息 充电桩 中心系统 0x77
    public static final byte COMMAND_0x77 = (byte)0x77;




}
