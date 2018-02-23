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
    private long receiveTime;
    //使用日期
    private long useTime;
    //券状态(1:未使用，2:已使用,3:已过期)
    private String type;

    public Voucher() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBusaccount() {
        return busaccount;
    }

    public void setBusaccount(String busaccount) {
        this.busaccount = busaccount;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(long receiveTime) {
        this.receiveTime = receiveTime;
    }


    public long getUseTime() {
        return useTime;
    }

    public Voucher(String uuid, String busaccount, String activity, String coupon, String code, String claim, long receiveTime, long useTime, String type) {
        this.uuid = uuid;
        this.busaccount = busaccount;
        this.activity = activity;
        this.coupon = coupon;
        this.code = code;
        this.claim = claim;
        this.receiveTime = receiveTime;
        this.useTime = useTime;
        this.type = type;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "uuid='" + uuid + '\'' +
                ", busaccount='" + busaccount + '\'' +
                ", activity='" + activity + '\'' +
                ", coupon='" + coupon + '\'' +
                ", code='" + code + '\'' +
                ", claim='" + claim + '\'' +
                ", receiveTime=" + receiveTime +
                ", useTime=" + useTime +
                ", type='" + type + '\'' +
                '}';
    }
}
