package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description: 懒汉式 + 同步 (线程不安全  不推荐使用)
 * @author: JF1sh
 * @create: 2020-05-26 23:20
 **/
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {
    }

    public  static Singleton5 getInstance5() {
        if (instance == null) {
            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }
}

// 在17行运行时，同样会因为线程都进入了if创建多个实例