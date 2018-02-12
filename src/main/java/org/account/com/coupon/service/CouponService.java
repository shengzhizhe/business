package org.account.com.coupon.service;

import org.account.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CouponService {
    ResponseResult getByBussinessAccount(String businessaccount);
}
