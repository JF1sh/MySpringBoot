package cn.lijy.demo.until.xc.Runnable;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description: 使用Synchronized，两个线程打印奇偶数
 * @author: JF1sh
 * @create: 2020-04-27 20:23
 **/
public class SynchronizePrintOdevity {

    static int num = 0;

    static Object clock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num < 101) {
                    synchronized (clock) {
                        if ((num & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                        }
                    }
                }
            }
        }, "偶数：");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num < 101) {
                    synchronized (clock) {
                        if ((num & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                        }
                    }
                }
            }
        }, "基数：");

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }


}
