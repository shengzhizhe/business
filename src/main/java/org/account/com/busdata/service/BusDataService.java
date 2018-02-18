package org.account.com.busdata.service;

import org.account.com.busdata.model.BusDataModel;
import org.account.com.util.resultJson.ResponseResult;

public interface BusDataService {
    ResponseResult add(BusDataModel busDataModel);
    /**
     * 根据id获取实体
     *
     * @param id
     * @return
     */
    ResponseResult getById(String id);

    /**
     * 根据账户获取实体
     *
     * @param account
     * @return
     */
    ResponseResult getByAccount(String account);

    /**
     * 根据类型获取账户
     *
     * @return
     */
    ResponseResult findAllPage(int pageNow, int pageSize, String type,String account);

    /**
     * 根据id删除实体
     *
     * @param id
     * @return
     */
    ResponseResult del(String id);

    /**
     * 修改商家资料
     *
     * @param model
     * @return
     */
    ResponseResult update(BusDataModel model);

}
