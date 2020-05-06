package cn.lijy.demo.until.xc.UncaughtExceptionHandler;

/**
 * @program: cn.lijy.demo.until.xc.UncaughtExceptionHandler
 * @description: 设置自己的异常捕获器。
 * @author: JF1sh
 * @create: 2020-05-06 21:13
 **/
public class UseMyHandler implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseMyHandler(),"Thread-1").start();
        Thread.sleep(300);
        new Thread(new UseMyHandler(),"Thread-2").start();
        Thread.sleep(300);
        new Thread(new UseMyHandler(),"Thread-3").start();
        Thread.sleep(300);
        new Thread(new UseMyHandler(),"Thread-4").start();
    }


    @Override
    public void run() {
    throw new RuntimeException();
    }
}
