package cn.lijy.demo.until.xc.ThreadReturnHandle;

import java.util.concurrent.Callable;

/**
 * 处理线程返回值
 * 3，实现callable接口。
 * 弥补了runnable无法返回参数的短板
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value ="done";
        System.out.println("MyCallable: Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("MyCallable: work over");
        return value;
    }
}
