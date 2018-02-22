package org.account.com.voucher.controller;

import io.swagger.annotations.Api;
import org.account.com.util.resultJson.ResponseResult;
import org.account.com.voucher.service.serviceImpl.VouchaerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "voucher",description = "已发出的优惠券")
@RestController
@RequestMapping("/voucher")
public class VoucherController {

    @Autowired
    private VouchaerServiceImpl service;

    /**
     * 根据领取人查找
     *
     */
    @RequestMapping("/getByClaim")
    public ResponseResult getByClaim(@RequestParam("claim")String claim){
        return null;
    }

    /**
     * 根据发行商家查找
     *
     */
    @RequestMapping("/getByBusaccount")
    public ResponseResult getByBusaccount(@RequestParam("busaccount")String busaccount){
        return null;
    }

    /**
     * 根据优惠券编码查找
     *
     */
    @RequestMapping("/getByCode")
    public ResponseResult getByCode(@RequestParam("code")String code){
        return null;
    }

    /**
     * 更改优惠券过期状态
     *
     */
    @RequestMapping("/updateBy")
    public ResponseResult updateBy(){
        return null;
    }
}
