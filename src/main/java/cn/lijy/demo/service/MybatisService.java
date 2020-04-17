package cn.lijy.demo.service;

import cn.lijy.demo.entity.EntitySwagger;
import cn.lijy.demo.entity.MybatisPojo;
import cn.lijy.demo.mapper.MybatisMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MybatisService {
    private static Logger  log= Logger.getLogger(MybatisService.class);



    /**
     *
     */
    @Autowired
    private MybatisMapper mybatisMapper;

    /**
     * 查询单个数据
     * */

    public String findServName(){
        return mybatisMapper.findservName();
    }



    /**
     * 根据ip查询整个数据
     * */
    public MybatisPojo findInfo(String ip){
      return   mybatisMapper.findInfoByIp(ip);
    }


    /**
     * 添加数据
     * */
    public int addDate(){

        MybatisPojo mybatisPojo =new MybatisPojo();
        mybatisPojo.setApiName("mybatisTest");
        mybatisPojo.setApiUrl("/url/test");
        mybatisPojo.setDataValue(3);
        mybatisPojo.setRequestResult("01");
        mybatisPojo.setServicIp("127.0.0.1");
        mybatisPojo.setServicName("OBCP");
        mybatisPojo.setCreateTime("2019-11-7");
        return  mybatisMapper.addDate(mybatisPojo);
    }

    /**
     * 使用 swagger 进行数据插入
     * @param entitySwagger
     * @return 返回是否成功
     */
    public  int addDateSwagger(EntitySwagger entitySwagger){
        int result=0;
        try{
            log.info(">>>>>> 使用Swagger 进行数据插入");
             result= mybatisMapper.addDateBySwagger(entitySwagger);
        }catch (Exception e){
            log.error(e.toString());
            log.error("当前参数为:" +entitySwagger);
        }
        return result;
    }





    /**
     * 使用 swagger 进行数据查询
     * @param ip
     * @param name
     * @return
     */
    public EntitySwagger findDateBySwagger(String ip,String name){
        log.info(">>>>>> 使用Swagger 进行数据查询");
      return   mybatisMapper.findInfoBySwagger(ip, name);
    }
}
