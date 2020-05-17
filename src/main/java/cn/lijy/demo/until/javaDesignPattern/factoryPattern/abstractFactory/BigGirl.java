package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 21:51
 **/
public class BigGirl implements Girl {
    @Override
    public void createGirl() {
        System.out.println("创建一个大女孩");
    }
}
