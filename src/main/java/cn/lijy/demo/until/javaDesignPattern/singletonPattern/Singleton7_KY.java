package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description:  静态内部类 可用
 * @author: JF1sh
 * @create: 2020-05-26 23:20
 **/
public class Singleton7_KY {

    private Singleton7_KY() {
    }

    private static class  SingletonInstance {
        private static final  Singleton7_KY  INSTANCE= new Singleton7_KY();
    }

    public  static Singleton7_KY getInstance5() {

        return SingletonInstance.INSTANCE;
    }
}
/**
 * 属于懒汉式写法
 * 将实例化的 INSTANCE 放入了内部类，在外部类加载的过程中，不会对内部类进行初始化
 * 只有当调用 getInstance5() 方法时，才会初始化 实例。
 * 由JVM保证了在初始化实例的 线程安全问题
 */
