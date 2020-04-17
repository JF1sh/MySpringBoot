package cn.lijy.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: cn.lijy.demo.common
 * @description: 编写 swagger 配置类
 * @author: JF1sh
 * @create: 2019-11-21 17:55
 **/

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket  createRestApi(ApiInfo apiInfo){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("cn.lijy.demo.controller")) //扫描哪个包
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))  //扫描注解
                .paths(PathSelectors.any())
                .build();
    }

    /**
    * @Description:   访问地址: http://localhost:8080/swagger-ui.html
    * @Param: [] 
    * @return: springfox.documentation.service.ApiInfo 
    * @Author: JF1sh
    * @Date: 2019/11/21 
    * @Time: 18:40
    **/
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("SpringDemo接口文档")
                // 设置联系人
//                .contact(new Contact("imooc-Nathan", "http://www.imooc.com", "scau_zns@163.com"))
                // 描述
                .description("详细信息如下")
                // 定义版本号
                .version("1.0").build();
    }
}
