package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description: 懒汉式 + 同步 (线程安全  不推荐使用)
 * @author: JF1sh
 * @create: 2020-05-26 23:20
 **/
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public synchronized static Singleton4 getInstance4() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

// 类锁加入  会导致效率降低 每次使用对象都会去竞争锁