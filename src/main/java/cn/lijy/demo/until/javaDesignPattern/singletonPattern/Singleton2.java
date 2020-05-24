package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description: 饿汉式 （静态代码块模式  可用）
 * @author: JF1sh
 * @create: 2020-05-25 00:29
 **/
public class Singleton2 {
    private final static  Singleton2 instance ;

    static {
        instance=new Singleton2();
    }

    private  Singleton2(){

    }

    public static Singleton2 getInstance1(){
        return instance;
    }


    // 与 singleton1 一样
}
