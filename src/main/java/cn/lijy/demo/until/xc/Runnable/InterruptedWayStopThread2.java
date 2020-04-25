package cn.lijy.demo.until.xc.Runnable;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description:
 *
 * 当 run() 调用的reInterrupt() 方法 抛出了 interruptException 异常时： 需要在run() 的 catch中来控制线程是否停止。
 *
 * 当 run() 调用的reInterrupt() 方法 捕获了 interruptException 异常时: 需要在reInterrupt() 的catch中来控制线程是否停止。
 *
 * @author: JF1sh
 * @create: 2020-04-22 21:52
 **/
public class InterruptedWayStopThread2 implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("come to Thread");
                reInterrupt();
        }
    }

    private void reInterrupt()  {
        System.out.println("come to reInterrupt");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptedWayStopThread2());
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        Thread.interrupted();
    }
}
