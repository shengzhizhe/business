package org.account.com.busdata.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.account.com.busdata.mapper.BusDataMapper;
import org.account.com.busdata.model.BusDataModel;
import org.account.com.busdata.service.BusDataService;
import org.account.com.service.impl.AccountServiceImpl;
import org.account.com.util.resultJson.ResponseResult;
import org.account.com.util.sl4j.Sl4jToString;
import org.account.com.util.uuidUtil.GetUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BusDataServiceImpl implements BusDataService {
    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private ResponseResult result;
    @Autowired
    private BusDataMapper mapper;

    @Override
    public ResponseResult add(BusDataModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                200,
                null));
        BusDataModel model1 = mapper.getByAccount(model.getAccount());
        if (model1 != null) {
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
                model.toString(),
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult getById(String id) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                200,
                null));
        BusDataModel model = mapper.getById(id);
        if (model != null) {
            result.setSuccess(true);
            result.setData(model);
            result.setCode(200);
        } else {
            result.setSuccess(false);
            result.setCode(404);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                200,
                null));
        return result;
    }

    @Override
    public ResponseResult getByAccount(String account) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                account,
                200,
                null));
        BusDataModel model = mapper.getByAccount(account);
        if (model != null) {
            result.setSuccess(true);
            result.setData(model);
            result.setCode(200);
        } else {
            result.setSuccess(false);
            result.setCode(404);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                account,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult findAllPage(int pageNow, int pageSize, String type, String account) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow + "," + pageSize + "," + type,
                200,
                null));
        PageHelper.startPage(pageNow, pageSize);
        Page<BusDataModel> page = mapper.findAllPage(type, account);
        result.setSuccess(true);
        if (page.size() > 0)
            result.setCode(200);
        else
            result.setCode(404);
        result.setData(page);
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow + "," + pageSize + "," + type,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult del(String id) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                200,
                null));
        int i = mapper.del(id);
        switch (i) {
            case 0:
                result.setSuccess(true);
                result.setCode(201);
                break;
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
                break;
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult update(BusDataModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                200,
                null));
        BusDataModel byId = mapper.getById(model.getUuid());
        if (byId == null) {
            result.setCode(404);
            result.setMessage("未找到资料");
            result.setSuccess(false);
        }else {
            int update = mapper.update(model);
            if(update == 1){
                result.setCode(200);
                result.setSuccess(true);
                result.setMessage("成功");
            }else {
                result.setCode(501);
                result.setSuccess(false);
                result.setMessage("修改失败");
            }
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                result.getCode(),
                null));
        return result;
    }
}
