package cn.lijy.demo.until.xc.Thread;

import java.util.Date;
import java.util.LinkedList;

/**
 * @program: cn.lijy.demo.until.xc.Thread
 * @description: 使用wait()/notify() 创建生产者消费者模式
 *
 * 原理：生产者生产到指定数量会去调用wait() 并且释放锁。
 *
 * @author: JF1sh
 * @create: 2020-04-25 23:28
 **/
public class ProducerConsumerModel {

    public static void main(String[] args) {
        EventStorage storage =new EventStorage();

        Thread thread1 = new Thread( new Producer(storage));
        Thread thread2 = new Thread( new Consumer(storage));

        thread1.start();
        thread2.start();
    }
}

//生产者
class Producer implements Runnable{

    private EventStorage Storage;

    public Producer(EventStorage storage) {
        this.Storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            Storage.put();
        }
    }
}

//消费者
class Consumer implements Runnable{

    private EventStorage Storage;

    public Consumer(EventStorage storage) {
        this.Storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            Storage.take();
        }
    }
}

//仓库
class  EventStorage {
    private int max;
    private  LinkedList<Date> storage;

    public EventStorage() {
        storage= new LinkedList<Date>();
        max=10;
    }
    public synchronized void put(){
        while (storage.size() == max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有:" + storage.size());
        notify();
    }

    public synchronized void take(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //LinkedList.poll()  == ArrayList.get(0)/ ArrayList.remove(0)
        System.out.println("消费者消费了:" + storage.poll()+"仓库剩余:" + storage.size());
        notify();
    }
}