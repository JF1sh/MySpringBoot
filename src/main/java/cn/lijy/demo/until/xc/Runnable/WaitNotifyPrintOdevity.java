package cn.lijy.demo.until.xc.Runnable;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description:
 * @author: JF1sh
 * @create: 2020-04-27 20:37
 **/
public class WaitNotifyPrintOdevity {
    static int num = 0;

    static Object clock = new Object();

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num < 101) {
                    synchronized (clock) {
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                            clock.notify();
                       if(num < 101){
                           try {
                               clock.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
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
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                            clock.notify();
                        if(num < 101){
                            try {
                                clock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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