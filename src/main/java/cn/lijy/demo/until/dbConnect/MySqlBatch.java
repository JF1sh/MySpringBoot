package cn.lijy.demo.until.dbConnect;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @program: SpringBoot_Demo
 * @description: 批量插入数据
 * @author: JF1sh
 * @create: 2019-11-07 19:30
 **/
@Component
public class MySqlBatch {
    private  static Logger log= Logger.getLogger(MySqlBatch.class);

    @Autowired
    DataSource dataSource;

    /**
    * @Description: 使用batch批量插入数据
    * @Param: []
    * @return: void
    * @Author: JF1sh
    * @Date: 2019/11/7
    * @Time: 19:40
    **/
    public void sqlBatch(){
        String perfix="INSERT INTO monitor_obcp_ce (servic_name,servic_ip,api_name,api_url,request_result,data_value,create_time) VALUES";
        StringBuffer suffix =new StringBuffer();

        try {
            java.sql.Connection connection =dataSource.getConnection();//获取配置中的连接池
            connection.setAutoCommit(false); //不自动提交事务
            PreparedStatement ptmt =connection.prepareStatement("");
            for (int i = 0; i <10 ; i++) {
                //拼接sql 第一个i 为第一个参数，第二个i为第二个参数
                suffix.append("('"+i+"','"+i+"'),");
            }
            String sql =perfix+suffix.substring(0,suffix.length());
            log.info(sql);
            ptmt.addBatch(sql);
            ptmt.executeBatch(); //执行上述sql
            connection.commit();
            connection.close();
            ptmt.close();
            suffix = new StringBuffer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
