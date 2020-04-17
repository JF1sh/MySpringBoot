package cn.lijy.demo.FileUpDown.apollo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @program: cn.lijy.demo.FileUpDown.apollo
 * @description:
 * @author: JF1sh
 * @create: 2019-12-18 18:51
 **/
public class Process implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactoryPostProcessor");
    }
}
