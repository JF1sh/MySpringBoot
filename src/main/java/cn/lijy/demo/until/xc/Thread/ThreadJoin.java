package cn.lijy.demo.until.xc.Thread;


/**
 * @program: cn.lijy.demo.until.xc.Thread
 * @description: join();底层还是调用了wait()方法。 每个Thread的run()方法执行完毕后会自动执行notifyAll()
 * @author: JF1sh
 * @create: 2020-04-27 23:16
 **/
public class ThreadJoin {

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
       Thread thread1= new Thread(new Runnable() {
           @Override
           public void run() {

           }
       }) ;


    }
}
