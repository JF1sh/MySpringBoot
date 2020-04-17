package cn.lijy.demo.until.xc.synchronize;

/**
 * @program: cn.lijy.demo.until.xc.synchronize
 * @description:  一个实例：使用Synchronized 修饰普通方法 为方法锁，默认锁当前对象。即使有多个方法都同用一把锁。线程串行，
 *                多个实例：只有多个实例时同时获取锁时才会并行
 *                一个实例： 而自定义锁，多个锁对应多个线程，则并行
 * @author: JF1sh
 * @create: 2020-04-15 22:03
 **/
public class SynchronizedClock2 implements Runnable {

    static SynchronizedClock2 sc1 = new SynchronizedClock2();


    Object clock1 = new Object();
    Object clock2 = new Object();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public void method1() {
        synchronized (clock1) {
            System.out.println("我是" + Thread.currentThread().getName() + "我拿到第一把锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是" + Thread.currentThread().getName() + "释放第一把锁");
        }
    }

    public void method2() {
        synchronized (clock2) {
            System.out.println("我是" + Thread.currentThread().getName() + "我拿第二把到锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是" + Thread.currentThread().getName() + "释放第二把锁");
        }
    }

    public static void main(String[] args) {
        Thread t1 =new Thread(sc1);
        Thread t2 =new Thread(sc1);

        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("完成");
    }
}
