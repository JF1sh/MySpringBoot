package cn.lijy.demo.until.xc.UncaughtExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: cn.lijy.demo.until.xc.Thread
 * @description: 编写自己的全局 UncaughtExceptionHandler
 * @author: JF1sh
 * @create: 2020-05-06 20:36
 **/
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    private String name ;


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //进行处理
        Logger log = Logger.getAnonymousLogger();
        log.log(Level.WARNING, "线程异常，终止运行" + t.getName(),e);
        System.out.println((name + ":捕获了异常," + t.getName() + "异常:" + e));
    }
}
