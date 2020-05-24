package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description: 单例模式 (饿汉式 静态常量 可用)
 * @author: JF1sh
 * @create: 2020-05-25 00:18
 **/
public class Singleton1 {
    private final static  Singleton1 instance = new Singleton1();

    private  Singleton1(){

    }

    public static Singleton1 getInstance1(){
        return instance;
    }

    // 由于被static修饰 所以在类加载的时候就会创建 Singleton1 的实例 (避免了线程同步问题，类加载是jvm虚拟机保证了线程安全)
    //构造函数私有化，提供公有方法返回实例
}
