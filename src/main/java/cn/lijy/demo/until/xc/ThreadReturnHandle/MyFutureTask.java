package cn.lijy.demo.until.xc.ThreadReturnHandle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask 获取返回值
 */
public class MyFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());

        new Thread(task).start();

        if (!task.isDone()) { //判断传给FutureTask的 实现类Callable的call()是否执行完毕
            System.out.println("task has not finished,please wait !!");
        }

        System.out.println(task.get());//用来阻塞当前调用它的线程直到call()方法执行完毕，取到返回值。还可以传入超时时间

        System.out.println("主线程完毕执行完毕");
    }
}
