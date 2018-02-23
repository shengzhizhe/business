package org.account.com.voucher.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.account.com.util.resultJson.ResponseResult;
import org.account.com.voucher.service.serviceImpl.VouchaerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @ApiOperation(value = "根据领取人查找",
            notes = "成功:200,失败:400,未找到:404",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/getByClaim",
    method = RequestMethod.GET)
    public ResponseResult getByClaim(@RequestParam("claim")String claim){
        return service.getByClaim(claim);
    }

    /**
     * 根据发行商家查找
     *
     */
    @ApiOperation(value = "根据发行商家查找",
            notes = "成功:200,失败:400,未找到:404",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/getByBusaccount",
    method = RequestMethod.GET)
    public ResponseResult getByBusaccount(@RequestParam("busaccount")String busaccount){
        return service.getByBusaccount(busaccount);
    }

    /**
     * 根据优惠券编码查找
     *
     */
    @ApiOperation(value = "根据优惠券编码查找",
            notes = "成功:200,失败:400,未找到:404",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/getByCode",
    method = RequestMethod.GET)
    public ResponseResult getByCode(@RequestParam("code")String code){
        return service.getByCode(code);
    }

    /**
     * 更改优惠券过期状态
     *
     */
    @ApiOperation(value = "更改优惠券过期状态",
            notes = "成功:200,失败:400,未找到:404",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/updateById",
    method = RequestMethod.GET)
    public ResponseResult updateById(@RequestParam("id")String id){
        return service.updateById(id);
    }
}
