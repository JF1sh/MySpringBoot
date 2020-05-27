package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description: 单例模式 双重检查 配合volatile  (推荐使用)
 * @author: JF1sh
 * @create: 2020-05-26 23:20
 **/
public class Singleton6_KY_TJ {
    private volatile static Singleton6_KY_TJ instance;

    private Singleton6_KY_TJ() {
    }

    public  static Singleton6_KY_TJ getInstance5() {
        if (instance == null) {
            synchronized (Singleton6_KY_TJ.class){
                if (instance == null) {
                    instance = new Singleton6_KY_TJ();
                }
            }
        }
        return instance;
    }
}

// 双重检查的好处：
// 优点: 线程安全 ，延迟加载，效率较高
// 为什么要 double-check 1：线程安全 2：但check不行  3:性能问题
// 为什么要用volatile :  1:新建对象有三步 2:重排序导致npe  3:防止重排序

/**
 *  给返回的实例对象加上 volatile (防止指令重排序)
 *  instance = new Singleton6(); 并非原子操作 ，在jvm中做了3件事
 *      1：给instance 分配内存 (新建一个空的对象)
 *      2：调用Singleton的构造函数来初始化成员变量
 *      3: 将instance对象指向分配的内存空间 (设置引用指向分配的内存)
 *
 */