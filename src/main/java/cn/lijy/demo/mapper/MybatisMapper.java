package cn.lijy.demo.mapper;

import cn.lijy.demo.entity.EntitySwagger;
import cn.lijy.demo.entity.MybatisPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MybatisMapper {

     /**
     * @Description:  查询单个数据
     * @Param: [null]
     * @return: java.lang.String
     * @Author: JF1sh
     * @Date: 2019/11/7
     * @Time: 9:52
     **/
     @Select("SELECT  servic_name FROM monitor_ce WHERE id =12")
     String findservName();


     /**
     * @Description:  根据条件查对象
     * @Param: [ip] --> String
     * @return: cn.lijy.demo.entity.MybatisPojo
     * @Author: JF1sh
     * @Date: 2019/11/6
     * @Time: 16:15
     **/
     @Select("select id id,servic_name servicName,servic_ip servicIp ,api_name apiName,api_url apiUrl,request_result requestResult,data_value dataValue,create_time createTime from monitor_obcp_ce where servic_ip= #{ip}")
     MybatisPojo findInfoByIp(String ip);


     /**
     * @Description: 插入数据
     * @Param: [mybatisPojo] 
     * @return: int 
     * @Author: JF1sh 
     * @Date: 2019/11/7 
     * @Time: 9:51
     **/
     @Insert("INSERT INTO monitor_obcp_ce (servic_name,servic_ip,api_name,api_url,request_result,data_value,create_time)\n" +
             " VALUES(#{mybatisPojo.servicName},#{mybatisPojo.servicIp},#{mybatisPojo.apiName},#{mybatisPojo.apiUrl},#{mybatisPojo.requestResult},#{mybatisPojo.dataValue},#{mybatisPojo.createTime})")
     int addDate(@Param("mybatisPojo") MybatisPojo mybatisPojo);


     /**
      * 使用 swagger 插入数据
      * @param entitySwagger
      * @return 返回是否成功
      */
     @Insert("INSERT INTO monitor_obcp_ce (servic_name,servic_ip,api_name,api_url,request_result,data_value,create_time)\n" +
             " VALUES(#{entitySwagger.servicName},#{entitySwagger.servicIp},#{entitySwagger.apiName},#{entitySwagger.apiUrl},#{entitySwagger.requestResult},#{entitySwagger.dataValue},#{entitySwagger.createTime})")
     int addDateBySwagger(@Param("entitySwagger") EntitySwagger entitySwagger);


     /**
      * 使用 swagger 查询数据
      *  以下为两种方式进行传参
      * @param ip
      * @param name
      * @return
      */
//     @Select("select id id,servic_name servicName,servic_ip servicIp ,api_name apiName,api_url apiUrl,request_result requestResult,data_value dataValue,create_time createTime from monitor_obcp_ce where servic_ip= #{0} and servic_name =#{1}")
//     EntitySwagger findInfoBySwagger(String ip,String name);
     @Select("select id id,servic_name servicName,servic_ip servicIp ,api_name apiName,api_url apiUrl,request_result requestResult,data_value dataValue,create_time createTime from monitor_obcp_ce where servic_ip= #{ip} and servic_name =#{name}")
     EntitySwagger findInfoBySwagger(@Param("ip") String ip,@Param("name") String name);
}
