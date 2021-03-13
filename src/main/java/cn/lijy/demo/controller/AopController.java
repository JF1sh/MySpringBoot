package cn.lijy.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用AOP记录日志
 */
@RestController
public class AopController {

    @RequestMapping(value = "/aop",method = RequestMethod.GET)
    @ResponseBody
    public String hello (){
        String sentence ="hello word";

        return sentence;
    }
}
