package org.account.com.activity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.account.com.activity.model.Activity;
import org.account.com.activity.service.ActivityService;
import org.account.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * '@name' 用户管理
 * <p>
 * '@Api' 用在类上，说明该类的作用
 * '@ApiOperation' 用在方法上，说明方法的作用
 * '@ApiImplicitParams' 用在方法上包含一组参数说明
 * '@ApiImplicitParam' 用在@ApiImplicitParams注解中，指定一个请求参数的各个方面 paramType：参数放在哪个地方
 * header-->请求参数的获取：@RequestHeader
 * query-->请求参数的获取：@RequestParam
 * path（用于restful接口）-->请求参数的获取：@PathVariable
 * body（不常用）
 * form（不常用）
 * name：参数名
 * dataType：参数类型
 * required：参数是否必须传
 * value：参数的意思
 * defaultValue：参数的默认值
 * '@ApiResponses'：用于表示一组响应
 * '@ApiResponse'：用在@ApiResponses中，一般用于表达一个错误的响应信息 code：数字，例如400
 * message：信息，例如"请求参数没填好"
 * response：抛出异常的类
 * '@ApiModel'：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，
 * 请求参数无法使用@ApiImplicitParam注解进行描述的时候）
 * '@ApiModelProperty'：描述一个model的属性
 */
@Api(value = "activity", description = "活动")
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @ApiOperation(value = "活动分页",
            notes = "type：null为查询所有，指定为查询指定类型的账户",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/page",
            method = RequestMethod.GET)
    public ResponseResult init(@RequestParam(value = "pageNow") int pageNow,
                               @RequestParam(value = "pageSize") int pageSize,
                               @RequestParam(value = "type", required = false) String names,
                               @RequestParam(value = "account", required = false) String businesnames) {
        return service.findAllPage(pageNow, pageSize, names, businesnames);
    }

    @ApiOperation(value = "根据ID查找活动",
            notes = "200:成功；404:活动未找到",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/getById",
            method = RequestMethod.GET)
    public ResponseResult getById(@RequestParam(value = "uuid") String uuid) {
        return service.getById(uuid);
    }

    /**
     * produces = "application/json;charset=utf-8"
     * consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
     */
    @ApiOperation(value = "添加活动",
            notes = "200:成功；501:活动重复,400:数据格式不符合要求",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult add(@RequestBody Activity model) {
//新增账户
        return service.add(model);
    }

    @ApiOperation(value = "根据ID删除活动",
            notes = "200:成功；404:活动未找到",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/delById",
            method = RequestMethod.GET)
    public ResponseResult delById(@RequestParam(value = "uuid") String uuid) {
        return service.getById(uuid);
    }
}
