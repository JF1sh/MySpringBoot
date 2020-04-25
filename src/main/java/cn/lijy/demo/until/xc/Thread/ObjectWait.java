package cn.lijy.demo.until.xc.Thread;

/**
 * @program: cn.lijy.demo.until.xc.Thread
 * @description: 简单使用 object 中的 wait()方法 和 notify() 方法
 * 注意：wait()方法 和 notify()  需要在synchronized代码块中执行。即是需要先获取monitor
 * 执行顺序：当Thread1获取到锁时，会执行到 wait(); 并且释放锁。这个时候Thread2获取到锁，执行完自己的逻辑。并执行notify().
 * 此时Thread2重新获取到锁，会执行wait() 之后的逻辑。
 * 特点：wait()方法 会释放锁。且只会释放执行wait()的锁。
 * @author: JF1sh
 * @create: 2020-04-25 21:11
 **/
public class ObjectWait {

    public volatile static int num = 0;

    public static Object object = new Object();


    static class Thread1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + ":获取到锁。");
                System.out.println(Thread.currentThread().getName() + ":" + "当前num:" + num);
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + "当前num:" + num);
                System.out.println(Thread.currentThread().getName() + "：重新获取到锁");
                System.out.println(Thread.currentThread().getName() + "：执行完毕");

            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + ":获取到锁。");
                num = 2;
                object.notify();
                System.out.println(Thread.currentThread().getName() + "执行了notify()方法");
                System.out.println(Thread.currentThread().getName() + ":执行完毕。");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }

}
