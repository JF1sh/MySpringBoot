package cn.lijy.demo.until.java.JMM.outOfOrderExecution;


import java.util.concurrent.CountDownLatch;

/**
 * @program: cn.lijy.demo.until.java.JMM.outOfOrderExecution
 * @description: jmm -> 重排序 现象
 * 加了 volatile 后禁止重排序 将不会再出现 0:0 这种情况
 * @author: JF1sh
 * @create: 2020-05-20 23:29
 **/
public class OutOfOrderExecution1 {

    private  volatile static int x = 0, y = 0;
    private     static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);//几次倒计时
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });

            t1.start();
            t2.start();
            countDownLatch.countDown();
            t1.join();
            t2.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次:" + "x=" + x + ",y=" + y);
                break;
            }else {
                System.out.println("第" + i + "次:" + "x=" + x + ",y=" + y);
            }

        }


    }
}
