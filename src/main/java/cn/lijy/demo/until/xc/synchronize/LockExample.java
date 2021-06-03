package cn.lijy.demo.until.xc.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: cn.lijy.demo.until.xc.synchronize
 * @description:
 * @author: JF1sh
 * @create: 2020-04-15 23:37
 **/
public class LockExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        //参数设置为true 倾向于将锁赋予等待时间最久的线程
        //公平锁：获取锁的顺序按先调用lock方法的先后顺序执行(慎用)
        //非公平锁：抢占的顺序不一定，看运气
    }

}
