package org.account.com.voucher.service.serviceImpl;

import org.account.com.util.resultJson.ResponseResult;
import org.account.com.util.sl4j.Sl4jToString;
import org.account.com.voucher.mapper.VoucherMapper;
import org.account.com.voucher.model.Voucher;
import org.account.com.voucher.service.VoucherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VouchaerServiceImpl implements VoucherService{
    private static Logger logger = LoggerFactory.getLogger(VouchaerServiceImpl.class);
    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private ResponseResult result;
    @Autowired
    private VoucherMapper mapper;
    @Override
    public ResponseResult getByClaim(String claim) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                claim.toString(),
                200,
                null));
        List<Voucher> byClaim = mapper.getByClaim(claim);
        if(byClaim.size()==0){
            result.setCode(404);
            result.setSuccess(false);
        }else{
            result.setCode(200);
            result.setSuccess(true);
            result.setData(byClaim);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                claim.toString(),
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult getByBusaccount(String busaccount) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                busaccount.toString(),
                200,
                null));
        List<Voucher> byBusaccount = mapper.getByBusaccount(busaccount);
        if(byBusaccount.size()==0){
            result.setCode(404);
            result.setSuccess(false);
        }else {
            result.setCode(200);
            result.setSuccess(true);
            result.setData(byBusaccount);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                busaccount.toString(),
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult getByCode(String code) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                code.toString(),
                200,
                null));
        Voucher byCode = mapper.getByCode(code);
        if(byCode==null){
            result.setCode(404);
            result.setSuccess(false);
        }else{
            result.setCode(200);
            result.setSuccess(true);
            result.setData(byCode);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                code.toString(),
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult updateById(String id) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id.toString(),
                200,
                null));
        int i = mapper.updateById(id);
        if(i==0){
            result.setCode(400);
            result.setSuccess(false);
        }else{
            result.setCode(200);
            result.setSuccess(true);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id.toString(),
                result.getCode(),
                null));
        return result;
    }
}
