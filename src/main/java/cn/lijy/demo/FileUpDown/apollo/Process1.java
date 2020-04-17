package cn.lijy.demo.FileUpDown.apollo;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * @program: cn.lijy.demo.FileUpDown.apollo
 * @description:
 * @author: JF1sh
 * @create: 2019-12-18 18:53
 **/
public class Process1 implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o,String s) throws BeansException {
        System.out.println("before");
        return o;
    }


    public Object postProcessAfterInitialization(Object o,String s) throws BeansException {
        System.out.println("after");
        return o;
    }
}
