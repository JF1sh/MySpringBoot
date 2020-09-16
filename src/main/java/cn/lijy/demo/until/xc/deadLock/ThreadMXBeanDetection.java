package cn.lijy.demo.until.xc.deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @program: cn.lijy.demo.until.xc.deadLock
 * @description: 用ThreadMXBean 检测死锁
 * @author: JF1sh
 * @create: 2020-06-14 21:23
 **/
public class ThreadMXBeanDetection implements Runnable {

    int flag = 1;

    static Object o1 = new Object();
    static Object o2 = new Object();


    public static void main(String[] args) throws InterruptedException {
        ThreadMXBeanDetection m1 = new ThreadMXBeanDetection();
        ThreadMXBeanDetection m2 = new ThreadMXBeanDetection();

        Thread t1 = new Thread(m1);
        m1.flag = 1;
        t1.start();

        Thread t2 = new Thread(m2);
        m2.flag = 2;
        t2.start();

        Thread.sleep(1000);//等待线程死锁后

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean(); //提供JVM信息的工厂类
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads(); //发现陷入死锁的线程id号

        if (deadlockedThreads != null && deadlockedThreads.length >0 ) {
            for (int i = 0; i <deadlockedThreads.length ; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);//拿到死锁线程的信息
                System.out.println(threadInfo.getLockName());
                System.out.println(threadInfo.getThreadName());
                System.out.println("");
                 t1.interrupt();
            }
        }
    }


    @Override
    public void run() {

        if (flag == 1) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "我拿到了o1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "我拿到了o2");
                }
            }
        }

        if (flag == 2) {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "我拿到了o1");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "我拿到了o2");
                }
            }
        }


    }
}