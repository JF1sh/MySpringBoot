package cn.lijy.demo.until.java.JMM.visibility;

/**
 * @program: cn.lijy.demo.until.java.JMM.visibility
 * @description: 可使用场景1：volatile 作为 刷新之前的触发器
 * 不加volatile c之前 以下代码有四种运行结果：(这是因为可见性的问题)
 * a=3 b=3
 * a=1 b=2
 * a=3 b=2
 * a=1 b=3
 * -----------
 * 加了 volatile int c = 0;后 起到了近朱者赤的道理，以使得之前的操作具有了可见性
 * 此为 happens-before 原则，保证了在get之前所有的set动作都会被看见
 * 需要两个线程对 volatile修饰的变量进行 读和写
 * @author: JF1sh
 * @create: 2020-05-22 00:13
 **/
public class Visibility2 {

    int a = 1;
    int b = 2;
    volatile int c = 0;

    private void setInt() {
        a = 3;
        b = a;
        c = 1;
    }

    private void getInt() {
        if (c == 1) {
            System.out.println("a:" + a + " ,b:" + b);
        }
    }

    public static void main(String[] args) {
        while (true) {
            Visibility2 visibility2 = new Visibility2();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    visibility2.setInt();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    visibility2.getInt();
                }
            });
            t1.start();
            t2.start();
        }
    }


}
