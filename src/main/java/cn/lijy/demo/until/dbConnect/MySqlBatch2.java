package cn.lijy.demo.until.dbConnect;

import cn.lijy.demo.entity.MybatisPojo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: cn.lijy.demo.until.dbConnect
 * @description:
 * @author: JF1sh
 * @create: 2019-12-03 15:52
 **/
@Component
public class MySqlBatch2 {

    private static Logger log = Logger.getLogger(MySqlBatch2.class);

    @Autowired
    DataSource dataSource;

    public void addBacth(List<MybatisPojo> list){
        try {
            String perfix="INSERT INTO monitor_obcp_ce (servic_name,servic_ip,api_name,api_url,request_result,data_value,create_time) VALUES (?,?,?,?,?,?,?)";
            java.sql.Connection connection =dataSource.getConnection();//获取配置中的连接池
            connection.setAutoCommit(false); //不自动提交事务
            PreparedStatement ptmt =connection.prepareStatement(perfix); //获取prepareStatement
            for(int i =0 ;i<list.size();i++){
            ptmt.setString(1,list.get(i).getServicName());
            ptmt.setString(2,list.get(i).getServicIp());
            ptmt.setString(3,list.get(i).getApiName());
            ptmt.setString(4,list.get(i).getApiUrl());
            ptmt.setString(5,list.get(i).getRequestResult());
            ptmt.setInt(6   ,list.get(i).getDataValue());
            ptmt.setString(7,list.get(i).getCreateTime());
            ptmt.addBatch();
            }
            long start = System.currentTimeMillis();//获取一个时间戳
            ptmt.executeBatch();//执行批处理
            long end = System.currentTimeMillis();//获取一个时间戳
            log.info("用时："+(end-start)+"ms");
            connection.commit();
            connection.close();
            ptmt.close();
        }catch (Exception e){
            log.error(e.toString());
        }

    }

}
