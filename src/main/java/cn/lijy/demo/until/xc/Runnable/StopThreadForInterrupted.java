package cn.lijy.demo.until.xc.Runnable;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description: 在run方法中没有 sleep 和 wait 等方法时，使用interrupt()和线程状态 来中断线程
 * @author: JF1sh
 * @create: 2020-04-21 20:35
 **/
public class StopThreadForInterrupted implements  Runnable{

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() &&  num <= Integer.MAX_VALUE/2   ){
            if(num % 10000 ==0){
                System.out.println(num + ":是10000的倍数");
            }
            num++;
        }
        System.out.println("结束");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new StopThreadForInterrupted());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }


}
