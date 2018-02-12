package org.account.com.coupon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.account.com.coupon.model.Coupon;
import org.account.com.coupon.service.CouponService;
import org.account.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "coupon", description = "优惠券")
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiOperation(value = "商家优惠券进入页", notes = "200：成功返回，404：该商家暂时未发布优惠券",
            response = ResponseResult.class, httpMethod = "Get")
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ResponseResult init(String businessaccount) {
        return couponService.getByBussinessAccount(businessaccount);
    }

    @ApiOperation(value = "发布优惠券", notes = "200:成功发布，400：数据格式不正确，500：发布失败",
            response = ResponseResult.class, httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult add(@RequestBody Coupon coupon) {
        return null;
    }


}
