package org.account.com.voucher.model;

import java.sql.Timestamp;

//已发出的券
public class Voucher {
    //主键
    private String uuid;
    //发行商家
    private String busaccount;
    //所属活动
    private String activity;
    //所属优惠券类型
    private String coupon;
    //优惠券编码
    private String code;
    //领取人
    private String claim;
    //领取日期
    private Timestamp receiveTime;
    //使用日期
    private Timestamp useTime;
    //券状态(1:未使用，2:已使用,3:已过期)
    private String type;
}
