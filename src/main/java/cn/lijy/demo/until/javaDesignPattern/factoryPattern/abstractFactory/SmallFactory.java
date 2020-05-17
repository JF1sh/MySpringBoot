package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 22:01
 **/
public class SmallFactory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new SmallBoy();
    }

    @Override
    public Girl getGirl() {
        return new SmallGill();
    }
}
