package cn.lijy.demo.until.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: SpringBoot_Demo
 * @description:  连接数据库
 * @author: JF1sh
 * @create: 2019-11-07 18:17
 **/
public class ConnectMySql {

    private  static  final  String URL="jdbc:mysql://localhost:3306/prometheus?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
    private  static  final  String USER="root";
    private  static  final  String PASSWORD="123";
    private   static   Connection connection=null;

    static {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //连接数据库
        try {
            connection=(Connection) DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  Connection getConnection(){
       return connection;
    }
}
