package cn.lijy.demo.until.xc.Runnable;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description: 实现Runnable类 实现卖票（使用3个线程）
 *
 * Runnable的代码可以被多个线程（Thread实例）共享，适合于多个线程处理同一资源的情况。start (总共卖5张)
 *
 * @author: JF1sh
 * @create: 2020-04-12 23:46
 **/
class MyThread implements Runnable{
    private int ticketsCont = 5; //火车站有五张票
    @Override
    public void run() {
        while (ticketsCont > 0){
            ticketsCont -- ;
            /*Thread.currentThread() 得到当前线程*/
            System.out.println(Thread.currentThread().getName() + "卖了一张票 剩余：" + ticketsCont);
        }
    }
}

public class TestRunnable {

    public static void main(String[] args) {
        MyThread mt = new MyThread();

        Thread th1 = new Thread(mt,"窗口1:");
        Thread th2 = new Thread(mt,"窗口2:");
        Thread th3 = new Thread(mt,"窗口3:");

        th1.start();
        th2.start();
        th3 .start();
    }
}
