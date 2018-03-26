package org.account.com.commodity.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.account.com.commodity.mapper.CommodityMapper;
import org.account.com.commodity.model.CommodityModel;
import org.account.com.commodity.service.CommodityService;
import org.account.com.util.resultJson.ResponseResult;
import org.account.com.util.sl4j.Sl4jToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CommodityServiceImp implements CommodityService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImp.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @Resource
    private ResponseResult result;
    @Autowired
    private CommodityMapper mapper;

    @Override
    public ResponseResult findByBusId(int pageNow, int pageSize, String busid) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow + "," + pageSize + "," + busid,
                200,
                null));
        PageHelper.startPage(pageNow, pageSize);
        Page<CommodityModel> byBusId = mapper.findByBusId(busid);
        if (byBusId.size()>0){
            result.setSuccess(true);
            result.setCode(200);
            result.setData(byBusId);
            result.setMessage("成功");
        }else{
            result.setMessage("失败");
            result.setCode(400);
            result.setSuccess(false);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow + "," + pageSize + "," + busid,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult getByUuid(String uuid) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                200,
                null));
        CommodityModel byUuid = mapper.getByUuid(uuid);
        if (byUuid!=null&&!"".equals(byUuid)){
            result.setSuccess(true);
            result.setCode(200);
            result.setData(byUuid);
            result.setMessage("成功");
        }else{
            result.setMessage("失败");
            result.setCode(400);
            result.setSuccess(false);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult add(CommodityModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.getUuid()+":"+model.getPp()+":"+model.getCname()+":"+model.getSl()+":"+model.getDw()+";"+model.getBusid()+
                ":"+model.getJg(),
                200,
                null));
        int add = mapper.add(model);
        if (add>0){
            result.setSuccess(true);
            result.setCode(200);
            result.setData(add);
            result.setMessage("成功");
        }else{
            result.setMessage("失败");
            result.setData(add);
            result.setCode(400);
            result.setSuccess(false);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.getUuid()+":"+model.getPp()+":"+model.getCname()+":"+model.getSl()+":"+model.getDw()+";"+model.getBusid()+
                        ":"+model.getJg(),
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult del(String uuid) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                200,
                null));
        int del = mapper.del(uuid);
        if (del>0){
            result.setSuccess(true);
            result.setCode(200);
            result.setData(del);
            result.setMessage("成功");
        }else{
            result.setMessage("失败");
            result.setCode(400);
            result.setSuccess(false);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult Update(CommodityModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.getUuid()+":"+model.getPp()+":"+model.getCname()+":"+model.getSl()+":"+model.getDw()+";"+model.getBusid()+
                        ":"+model.getJg(),
                200,
                null));
        int update = mapper.Update(model);
        if (update>0){
            result.setSuccess(true);
            result.setCode(200);
            result.setData(update);
            result.setMessage("成功");
        }else{
            result.setMessage("失败");
            result.setCode(400);
            result.setSuccess(false);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.getUuid()+":"+model.getPp()+":"+model.getCname()+":"+model.getSl()+":"+model.getDw()+";"+model.getBusid()+
                        ":"+model.getJg(),
                result.getCode(),
                null));
        return result;
    }
}
