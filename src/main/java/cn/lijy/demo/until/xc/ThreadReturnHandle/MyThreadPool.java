package cn.lijy.demo.until.xc.ThreadReturnHandle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 第2种：使用线程池获取返回值
 * 使用线程池可以提交多个实现callable的类 并发处理结果
 */
public class MyThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();//获取线程池
        Future<String> future = service.submit(new MyCallable());//提交任务

        if (!future.isDone()){
            System.out.println("任务正在运行,请稍后");
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }

        System.out.println("主线程运行完毕");
    }
}
