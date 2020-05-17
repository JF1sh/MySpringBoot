package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 22:04
 **/
public class PersonTest {

    public static void main(String[] args) {

        //创建大工厂
        PersonFactory factory = new BigFactory();
        //调用大工厂里面的创建男孩方法
        Boy boy = factory.getBoy();
        //调用大男孩实例
        boy.createBoy();



        //创建小工厂
        PersonFactory factory1 =new SmallFactory();
        //调用小工厂的创建女孩方法
        Girl girl= factory1.getGirl();
        //调用小女孩实例
        girl.createGirl();
    }
}
