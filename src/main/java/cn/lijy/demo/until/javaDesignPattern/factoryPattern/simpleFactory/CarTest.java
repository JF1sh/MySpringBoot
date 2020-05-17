package cn.lijy.demo.until.javaDesignPattern.factoryPattern.simpleFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.simpleFactory
 * @description:
 * @author: JF1sh
 * @create: 2020-05-14 21:05
 **/
public class CarTest {

    public static void main(String[] args) {

        //创建工厂
        CarFactory factory = new CarFactory();
        //生成对应的car实例
        CarInterface car= factory.getCar("bsj");
       //使用实例
        car.createCar();

    }


}
