package cn.lijy.demo.until.javaDesignPattern.factoryPattern.simpleFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.simpleFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 20:59
 **/
public class BsjCar implements CarInterface {
    @Override
    public void createCar() {
        System.out.println("我创建了一个保时捷");
    }
}
