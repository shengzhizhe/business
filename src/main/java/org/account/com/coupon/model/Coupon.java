package org.account.com.coupon.model;

import java.io.Serializable;
//优惠券
public class Coupon implements Serializable {
    //主键
    private String uuid;
    //起始时间
    private String startTime;
    //结束时间
    private String endTime;
    //商家
    private String businessaccount;
    //类型(1:折扣，2:抵现)
    private String type;
    //面额\折扣
    private Double number;
    //所属批次
    private String batch;
    //所属活动(活动主键)
    private String activity;
    //内容说明
    private String content;
    //使用地址
    private String address;
    //使用条件
    private String condition;
}
