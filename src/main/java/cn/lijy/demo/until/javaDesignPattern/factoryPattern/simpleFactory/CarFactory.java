package cn.lijy.demo.until.javaDesignPattern.factoryPattern.simpleFactory;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.simpleFactory
 * @description: 工厂模式，是通过类名发射创建实例
 * @author: JF1sh
 * @create: 2020-05-14 21:00
 **/
public class CarFactory {

    /**
     * 根据类名创建对象
     * @param key factory.properties配置文件对应的key
     * @return
     */
    public CarInterface getCar(String key){

        try {
            CarInterface car = (CarInterface) Class.forName(factoryUntil(key)).newInstance();
            return car;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 读取配置文件
     * @param key  key factory.properties配置文件对应的key
     * @return
     */
    private  String factoryUntil(String key){
        Properties props ;
            try {
                props= PropertiesLoaderUtils.loadAllProperties("factory.properties");
               String value= (String) props.get(key);
               return value;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
           return null;
    }
}
