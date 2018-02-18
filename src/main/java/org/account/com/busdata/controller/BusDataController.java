package org.account.com.busdata.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.account.com.busdata.model.BusDataModel;
import org.account.com.busdata.service.BusDataService;
import org.account.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(value = "busdata", description = "商家个人资料")
@RestController
@RequestMapping("/busdata")
public class BusDataController {
    @Autowired
    private BusDataService busDataServicel;

    /**
     * produces = "application/json;charset=utf-8"
     * consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
     */
    @ApiOperation(value = "添加商家资料",
            notes = "200:成功;501:资料重复;400:数据格式不符合要求",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult add(@RequestBody BusDataModel model) {
//新增账户
        return busDataServicel.add(model);
    }

    @ApiOperation(value = "根据id删除",
            notes = "200:成功；500:失败，201：该账户不存在",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/del",
            method = RequestMethod.GET)
    public ResponseResult del(@RequestParam("id") String id) {
        return busDataServicel.del(id);
    }

    @ApiOperation(value = "根据账户查找",
            notes = "200:成功；404:账户未找到",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/acc",
            method = RequestMethod.GET)
    public ResponseResult getByAccount(@RequestParam("account") String account) {
        return busDataServicel.getByAccount(account);
    }

    @ApiOperation(value = "根据id查找",
            notes = "根据id获取账户",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/id",
            method = RequestMethod.GET)
    public ResponseResult get(@RequestParam("id") String id) {
        return busDataServicel.getById(id);
    }

    @ApiOperation(value = "update",
            notes = "200:成功；501：失败；400：数据格式不正确；404:未找到数据",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult update(@RequestBody BusDataModel model) {
        return busDataServicel.update(model);
    }

}
