package org.account.com.activity.service;

import org.account.com.activity.model.Activity;
import org.account.com.util.resultJson.ResponseResult;


public interface ActivityService {

    ResponseResult findAllPage(int pageNow, int pageSize, String names, String businesnames);
    ResponseResult getById(String uuid);
    ResponseResult add(Activity model);
    ResponseResult del(String uuid);
}
