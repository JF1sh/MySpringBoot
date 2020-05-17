package cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.factoryPattern.abstractFactory
 * @description: 人物接口  提供男和女
 * @author: JF1sh
 * @create: 2020-05-14 21:55
 **/
public interface PersonFactory {

    //男孩接口
    Boy getBoy();

    //女孩接口
    Girl getGirl();

}
