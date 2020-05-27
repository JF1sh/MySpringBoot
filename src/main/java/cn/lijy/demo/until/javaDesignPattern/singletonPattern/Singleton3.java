package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description: 懒汉式 (线程不安全)
 * @author: JF1sh
 * @create: 2020-05-26 23:12
 **/
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance3(){

        if (instance == null) {
           instance = new  Singleton3();
        }
        return instance;
    }
}

//因为线程在运行过程中任何一步都会被抢占资源，所有懒汉式是线程不安全的
//违背了单例模式的初衷