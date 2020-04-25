package cn.lijy.demo.until.xc.Runnable;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description:
 * 在run()中有阻塞方法时，1：当阻塞方法被大的try/catch包裹时，当阻塞响应interrupt，会因为接收到InterruptException而停止线程
 *                      2：当阻塞方法独立被包裹，因为阻塞方法响应了interrupt，只是抛了异常，中断状态会被清除。方法仍然会继续跑
 *                         需要在catch{} 中 Thread.currentThread().interrupt(); 才会停止。
 * @author: JF1sh
 * @create: 2020-04-21 21:09
 **/
public class InterruptedWayStopThread implements Runnable {

    @Override
    public void run() {
        int num = 0;
        //
        try {
            while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + ":是100的倍数");
                }
                num++;
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new InterruptedWayStopThread());
        thread.start();
        Thread.sleep(50);
        thread.interrupt();
        System.out.println("ok");

    }


}
