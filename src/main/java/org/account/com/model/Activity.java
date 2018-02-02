package org.account.com.model;

import java.io.Serializable;
import java.sql.Timestamp;

//活动
public class Activity implements Serializable {
    //主键
    private String uuid;
    //主题
    private String theme;
    //名称
    private String names;
    //内容
    private String content;
    //起始时间
    private Timestamp startTime;
    //终止时间
    private Timestamp endTime;
    //商家(商家账号主键)
    private String businessaccount;
    //活动地址
    private String address;
    //批次
    private String batch;
}
