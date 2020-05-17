package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 22:00
 **/
public class BigFactory implements PersonFactory {

    @Override
    public Boy getBoy() {
        return new BigBoy();
    }

    @Override
    public Girl getGirl() {
        return new BigGirl();
    }
}
