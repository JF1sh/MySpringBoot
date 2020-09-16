package cn.lijy.demo.until.xc.deadLock.philosopher;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: cn.lijy.demo.until.xc.deadLock.philosopher
 * @description:  使用tryLock 避免死锁
 * @author: JF1sh
 * @create: 2020-06-22 22:52
 **/
public class TryLockDeadLock  implements Runnable{

    private static Lock lock1  =new ReentrantLock();
    private static Lock lock2  =new ReentrantLock();
    int flag = 1;

    @Override
    public void run() {
        while (true){
            if (flag == 1) {
                try {
                    if (lock1.tryLock(800, TimeUnit.MILLISECONDS)){
                        System.out.println(Thread.currentThread().getName() + "：拿到lock1");
                        Thread.sleep(new Random().nextInt(1000));
                        if(lock2.tryLock(800,TimeUnit.MILLISECONDS)){
                            System.out.println(Thread.currentThread().getName() + "：拿到两把锁");
                            Thread.sleep(2000);
                          Thread.sleep(new Random().nextInt(1000));
                            lock2.unlock();
                            lock1.unlock();
                            break;
                        }else {
                            System.out.println(Thread.currentThread().getName() + "：获取lock2失败");
                            lock1.unlock();//释放锁1
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + "：获取lock1失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (flag == 2) {
                try {
                    if (lock2.tryLock(800, TimeUnit.MILLISECONDS)){
                        System.out.println(Thread.currentThread().getName() + "：拿到lock2");
                        Thread.sleep(new Random().nextInt(1000));
                        if(lock1.tryLock(800,TimeUnit.MILLISECONDS)){
                            System.out.println(Thread.currentThread().getName() + "：拿到两把锁");
                            Thread.sleep(new Random().nextInt(1000));
                            lock1.unlock();
                            lock2.unlock();
                            break;
                        }else {
                            System.out.println(Thread.currentThread().getName() + "：获取lock1失败");
                            lock2.unlock();//释放锁2
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + "：获取lock2失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        TryLockDeadLock try1 = new TryLockDeadLock();
        TryLockDeadLock try2 = new TryLockDeadLock();

        Thread t1 = new Thread(try1,"线程1");
        Thread t2 = new Thread(try2,"线程2");

        try1.flag=1;
        t1.start();

        try2.flag=2;
        t2.start();
    }
}
