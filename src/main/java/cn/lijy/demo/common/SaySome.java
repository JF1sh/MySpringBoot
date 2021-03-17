package cn.lijy.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: cn.lijy.demo.common
 * @description:
 * @author: JF1sh
 * @create: 2020-03-12 23:21
 **/
@Component
public class SaySome implements ApplicationContextAware {

     private  ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.context =applicationContext;
//        List<String> lis = new ArrayList<>();
//        lis.add("127.0.0.1");
//        try {
//            System.out.println(context.getBean("mybatisService").getClass().getMethod("findInfo").getName());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            System.out.println("获取失败");
//        }
//        System.out.println(">>>>>"+context.getBean("mybatisService").getClass().getName());
    }



}
