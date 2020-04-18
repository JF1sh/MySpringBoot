package cn.lijy.demo.until.xc.synchronize;

/**
 * @program: cn.lijy.demo.until.xc.synchronize
 * @description: 多个实例：两个实例同时访问类中的锁，会并行
 * 一个实例： 会串行
 * @author: JF1sh
 * @create: 2020-04-14 23:04
 **/
public class SynchronizedClock implements Runnable {

    static SynchronizedClock sc1 = new SynchronizedClock();
    static SynchronizedClock sc2 = new SynchronizedClock();

    Object clock = new Object();

    @Override
    public void run() {
        synchronized (clock) {
            System.out.println("我是" + Thread.currentThread().getName() + "我拿到锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是" + Thread.currentThread().getName() + "释放锁");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(sc1);
        Thread t2 = new Thread(sc2);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("完成");
    }
}
