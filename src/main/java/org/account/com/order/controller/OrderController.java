package org.account.com.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.account.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "order",description = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {
    @ApiOperation(value = "查询订单列表",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/order/getByBusId/{uuid}",method = RequestMethod.GET)
    public ResponseResult getByBusId(@PathVariable String uuid){
        return null;
    }
}
