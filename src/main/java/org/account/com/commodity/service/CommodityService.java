package org.account.com.commodity.service;

import org.account.com.commodity.model.CommodityModel;
import org.account.com.util.resultJson.ResponseResult;

import java.util.List;

public interface CommodityService {
    ResponseResult findByBusId(int pageNow,int pageSize,String busid);
    ResponseResult getByUuid(String uuid);
    ResponseResult add(CommodityModel model);
    ResponseResult del(String uuid);
    ResponseResult Update(CommodityModel model);
}
