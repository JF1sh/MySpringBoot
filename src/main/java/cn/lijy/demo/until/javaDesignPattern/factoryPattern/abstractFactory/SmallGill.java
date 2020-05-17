package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 21:52
 **/
public class SmallGill  implements Girl{
    @Override
    public void createGirl() {
        System.out.println("来了一个小女孩");
    }
}
