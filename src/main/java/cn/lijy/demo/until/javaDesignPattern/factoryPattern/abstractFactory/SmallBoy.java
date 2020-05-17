package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 21:54
 **/
public class SmallBoy implements Boy {
    @Override
    public void createBoy() {
        System.out.println("来了一个小男人");
    }
}
