package cn.lijy.demo.until.xc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: cn.lijy.demo.until.xc
 * @description:
 * @author: JF1sh
 * @create: 2020-03-19 15:09
 **/
public class ThreadPool {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 4, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2)); //等于循环次数会有序进行。

     //   for(int i=0;i<3;i++){//多少此任务
            MyTask myTask = new MyTask();
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
     //   }

        executor.shutdown();
    }
}


class MyTask implements Runnable {
//    private int taskNum;
//
//    public MyTask(int num) {
//        this.taskNum = num;
//    }

    @Override
    public void run() {
        boolean flag = true;
        int num =0;
       // System.out.println("正在执行task "+taskNum);
 if( 1== 1){
     try {
         while (flag) {
             Thread.currentThread();

             // 执行需要逻辑
             // new test().say(taskNum + "");
          //   new test().say("taskNum");
             System.out.println("over");
             Thread.sleep(4000);
             num++;

             if(num == 2){
                 flag=false;
             }
         }
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     System.out.println("循环了" + num + "次");
     // System.out.println("task "+taskNum+"执行完毕");
 }
    }

}
// 　在ThreadPoolExecutor类中提供了四个构造方法：
//  corePoolSize：核心池的大小，默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
//  maximumPoolSize：线程池最大线程数，它表示在线程池中最多能创建多少个线程；
//  keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数对于核心池中的线程也会起作用，直到线程池中的线程数为0；
//  unit：参数keepAliveTime的时间单位；
//  workQueue：一个阻塞队列，用来存储等待执行的任务；
//  threadFactory：线程工厂，主要用来创建线程；
//  handler：表示当拒绝处理任务时的策略

