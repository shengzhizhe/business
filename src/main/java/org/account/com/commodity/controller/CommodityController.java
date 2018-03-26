package org.account.com.commodity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.account.com.commodity.model.CommodityModel;
import org.account.com.commodity.service.CommodityService;
import org.account.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "commodity",description = "商品")
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService service;

    @ApiOperation(value = "商品列表",
            notes = "200成功,400失败",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/init",
            method = RequestMethod.GET)
    public ResponseResult Init(@RequestParam(value = "pageNow") int pageNow,
                               @RequestParam(value = "pageSize") int pageSize,
                               @RequestParam("busid")String busid){
        return service.findByBusId(pageNow,pageSize,busid);
    }

    @ApiOperation(value = "单个商品",
            notes = "200成功,400失败",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/getbyuuid",
            method = RequestMethod.GET)
    public ResponseResult getByUuid(@RequestParam("uuid")String uuid){
        return service.getByUuid(uuid);
    }

    @ApiOperation(value = "增加商品",
            notes = "200成功,400失败",
            response = ResponseResult.class,
            httpMethod = "POST")
    @RequestMapping(value = "/add",
            method = RequestMethod.POST)
    public ResponseResult add(@ModelAttribute("from")CommodityModel model){
        return service.add(model);
    }

    @ApiOperation(value = "删除商品",
            notes = "200成功,400失败",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/del",
            method = RequestMethod.GET)
    public ResponseResult add(@RequestParam("uuid")String uuid){
        return service.del(uuid);
    }

    @ApiOperation(value = "编辑商品",
            notes = "200成功,400失败",
            response = ResponseResult.class,
            httpMethod = "POST")
    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public ResponseResult Update(@ModelAttribute("from")CommodityModel model){
        return service.Update(model);
    }
}
