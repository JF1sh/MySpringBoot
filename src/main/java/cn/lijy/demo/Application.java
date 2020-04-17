package cn.lijy.demo;


import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"cn.lijy.demo.mapper"})
public class Application {
    static ConfigurableApplicationContext cp=null;
    private static Logger  log =Logger.getLogger(Application.class);
    public static void main(String[] args) {
     // cp= SpringApplication.run(Application.class);
        SpringApplication app = new SpringApplication(Application.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println("启动成功！！");
        System.out.println("根地址: \t\thttp://127.0.0.1:" + env.getProperty("server.port"));
        System.out.println("登录接口: \thttp://127.0.0.1:" + env.getProperty("server.port") + "/user/login?loginName=test&password=test");
        log.info("application start ");
    }

}
