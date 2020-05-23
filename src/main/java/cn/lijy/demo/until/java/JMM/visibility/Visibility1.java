package cn.lijy.demo.until.java.JMM.visibility;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: cn.lijy.demo.until.java.JMM.visibility
 * @description: volatile 不适用 a++
 * 因为 a++ 时，会取决于之前的操作。
 * @author: JF1sh
 * @create: 2020-05-21 23:37
 **/
public class Visibility1 implements Runnable {
    int b;
    volatile int a;
    AtomicInteger realA = new AtomicInteger();// todo

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            b++;
            realA.incrementAndGet(); //自加操作
            a = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            Runnable visibility1 = new Visibility1();
            Thread t1 = new Thread(visibility1);
            Thread t2 = new Thread(visibility1);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            if (((Visibility1) visibility1).a == 0) {
                System.out.println(((Visibility1) visibility1).b);
                System.out.println(((Visibility1) visibility1).realA);
            }
            if (((Visibility1) visibility1).a != 20000) {
                break;
            }
        }
    }
}
