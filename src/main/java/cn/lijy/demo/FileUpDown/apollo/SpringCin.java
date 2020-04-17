package cn.lijy.demo.FileUpDown.apollo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: cn.lijy.demo.FileUpDown.apollo
 * @description:
 * @author: JF1sh
 * @create: 2019-12-18 18:36
 **/
public class SpringCin implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinition definition= new GenericBeanDefinition();
        definition.setBeanClassName("com.test.apollo.Process");
        BeanDefinition definition1= new GenericBeanDefinition();
        definition1.setBeanClassName("com.test.apollo.Process1");
        beanDefinitionRegistry.registerBeanDefinition("process",definition);
        beanDefinitionRegistry.registerBeanDefinition("process1",definition1);
    }
}
