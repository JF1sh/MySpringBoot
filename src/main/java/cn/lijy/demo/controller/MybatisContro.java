package cn.lijy.demo.controller;

import cn.lijy.demo.entity.MybatisPojo;
import cn.lijy.demo.service.MybatisService;
import cn.lijy.demo.until.dbConnect.MySqlBatch2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller  //使用Controller + responseBody   防止Swagger扫描
@RequestMapping("/mybatis")
public class MybatisContro  {

    @Autowired
    private MybatisService mybatisService;

    @Autowired
    private MySqlBatch2 mySqlBatch2;

    @RequestMapping("/index")
    public String index(){
        return "index1";
    }

    @RequestMapping(value = "/findByid",method = RequestMethod.POST)
    @ResponseBody
    public String findServName(){
        return mybatisService.findServName();
    }


    @RequestMapping(value = "/findInfoByIp",method = RequestMethod.POST)
    @ResponseBody
    public MybatisPojo findInfo(String ip){
       return mybatisService.findInfo(ip);
    }

    @RequestMapping(value = "/addDate",method = RequestMethod.POST)
    @ResponseBody
    public MybatisPojo add(){
        mybatisService.addDate();
       return mybatisService.findInfo("127.0.0.1");

    }


    @RequestMapping(value = "/addBatch")
    @ResponseBody
    public String useBatch(){
        List list =new ArrayList<MybatisPojo>();
        for (int i = 0; i <1000 ; i++) {
            MybatisPojo mp= new MybatisPojo();
            mp.setServicName("demo"+i);
            mp.setServicIp("10"+i);
            mp.setApiName("demo"+i);
            mp.setApiUrl("10"+i);
            mp.setRequestResult("11");
            mp.setDataValue(i);
            mp.setCreateTime("2019-12-03");
            list.add(mp);
        }

        mySqlBatch2.addBacth(list);
        return "ok";
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUSer(int num){
        System.out.println(mybatisService.addUser(num));
        return "add success";
    }

}
