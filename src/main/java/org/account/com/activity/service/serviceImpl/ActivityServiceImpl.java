package org.account.com.activity.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.account.com.activity.mapper.ActivityMapper;
import org.account.com.activity.model.Activity;
import org.account.com.activity.service.ActivityService;
import org.account.com.util.resultJson.ResponseResult;
import org.account.com.util.sl4j.Sl4jToString;
import org.account.com.util.uuidUtil.GetUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ActivityServiceImpl implements ActivityService
{

    private static Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @Resource
    private ResponseResult result;
    @Resource
    private ActivityMapper mapper;
    @Override
    public ResponseResult findAllPage(int pageNow, int pageSize, String names, String businesnames) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow + "," + pageSize + "," + names,
                200,
                null));
        PageHelper.startPage(pageNow, pageSize);
        Page<Activity> page = mapper.findAllPage(names,businesnames);
        result.setSuccess(true);
        if (page.size() > 0)
            result.setCode(200);
        else
            result.setCode(404);
        result.setData(page);
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow + "," + pageSize + "," + names,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult getById(String uuid) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                200,
                null));
        Activity page = mapper.getById(uuid);
        result.setSuccess(true);
        if (page != null)
            result.setCode(200);
        else
            result.setCode(404);
        result.setData(page);
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult add(Activity model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString()+"",
                200,
                null));
        Activity model1 = mapper.getByName(model.getNames());
        if (model1 != null&&model.getType()!=2) {
            result.setSuccess(false);
            result.setCode(501);
        } else {
            model.setUuid(GetUuid.getUUID());
            int i = mapper.add(model);
            switch (i) {
                case 1:
                    result.setSuccess(true);
                    result.setCode(200);
                    result.setMessage(model.getUuid());
                    break;
                default:
                    result.setSuccess(false);
                    result.setCode(500);
                    break;
            }
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString()+"",
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult del(String uuid)
    {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid+"",
                200,
                null));
        int del = mapper.del(uuid);
        switch (del)
        {
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                result.setMessage(uuid);
                break;
            default:
                result.setSuccess(false);
                result.setCode(404);
                break;
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid+"",
                result.getCode(),
                null));
        return result;
    }
}
