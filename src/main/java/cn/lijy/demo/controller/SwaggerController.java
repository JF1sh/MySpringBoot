package cn.lijy.demo.controller;

import cn.lijy.demo.entity.EntitySwagger;
import cn.lijy.demo.service.MybatisService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: cn.lijy.demo.controller
 * @description: 使用 swagger 生产接口文档
 * @author: JF1sh
 * @create: 2019-11-21 18:29
 **/

@RestController
@Api(value = "接口文档", tags = "数据查询接口")
@RequestMapping("/swagger")
public class SwaggerController {

    private static Logger log = Logger.getLogger(SwaggerController.class);

    @Autowired
    private MybatisService mybatisService;


    /**
     * @param filter
     * @return
     */
    @RequestMapping(value = "addSwaggerDate", method = RequestMethod.POST)
    @ApiOperation(value = "数据插入接口", notes = "数据插入")  //接口描述
    //  @ApiImplicitParam(name = "filter",value = "数据对象",dataType = "class",paramType = "from")  //入参
    @ApiResponse(response = String.class, code = 200, message = "返回是否成功")   //出参
    public String addSwaggerDate(EntitySwagger filter) {
        int result = mybatisService.addDateSwagger(filter);
        if ((result & 1) == 1) {
            return "ok";
        } else {
            return "no";
        }
    }


    /**
     * 查询数据*
     * @param ip
     * @param name
     * @return
     */
    @RequestMapping(value = "findDateBySwagger", method = RequestMethod.POST)
    @ApiOperation(value = "数据查询接口", notes = "查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ip", value = "所要查询的服务ip", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "所要查询的服务名", dataType = "String", paramType = "query")
    })
    @ApiResponse(response = EntitySwagger.class, code = 200, message = "所返回的对象")
    public EntitySwagger findDateBySwagger(String ip, String name) {

        return mybatisService.findDateBySwagger(ip, name);

    }

//    @ApiOperation()用于方法；
//
//    value用于方法描述
//
//            notes用于提示内容
//
//    tags可以重新分组（视情况而用）


//    @Api()用于类；
//
//    表示标识这个类是swagger的资源
//
// @ApiOperation()用于方法；
//
//    表示一个http请求的操作
//
// @ApiParam()用于方法，参数，字段说明；
//
//    表示对参数的添加元数据（说明或是否必填等）
//
//             @ApiModel()用于类
//
//    表示对类进行说明，用于参数用实体类接收
//
// @ApiModelProperty()用于方法，字段
//
//            表示对model属性的说明或者数据操作更改
//
// @ApiIgnore()用于类，方法，方法参数
//
//            表示这个方法或者类被忽略
//
// @ApiImplicitParam() 用于方法
//
//            表示单独的请求参数
//
// @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
//
//    @ApiResponse 
//
//    返回参数
//
//2、具体使用
//
//    @Api()用于类；
//
//    参数：
//
//    tags:表示说明，tags如果有多个值，会生成多个list
//
//    value:已废用
//
//    hidde:无效果
//
//    description:接口说明

}