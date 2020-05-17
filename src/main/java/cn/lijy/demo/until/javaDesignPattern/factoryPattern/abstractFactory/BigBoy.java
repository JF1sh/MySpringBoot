package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 21:53
 **/
public class BigBoy implements Boy {
    @Override
    public void createBoy() {
        System.out.println("生产了一个大男孩");
    }
}
