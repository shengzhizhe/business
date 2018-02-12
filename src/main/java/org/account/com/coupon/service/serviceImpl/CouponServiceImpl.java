package org.account.com.coupon.service.serviceImpl;

import org.account.com.coupon.mapper.CouponMapper;
import org.account.com.coupon.model.Coupon;
import org.account.com.coupon.service.CouponService;
import org.account.com.service.impl.AccountServiceImpl;
import org.account.com.util.resultJson.ResponseResult;
import org.account.com.util.sl4j.Sl4jToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Service
public class CouponServiceImpl implements CouponService {
    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private CouponMapper couponMapper;

    @Resource
    private ResponseResult result;

    @Override
    public ResponseResult getByBussinessAccount(String businessaccount) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                businessaccount,
                200,
                null));
        Coupon b = couponMapper.getByBussinessAccount(businessaccount);
        if(b!=null)
        {
            result.setSuccess(true);
            result.setData(b);
            result.setCode(200);
        }else {
            result.setSuccess(false);
            result.setCode(404);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                businessaccount,
                result.getCode(),
                null));
        return result;
    }
}
