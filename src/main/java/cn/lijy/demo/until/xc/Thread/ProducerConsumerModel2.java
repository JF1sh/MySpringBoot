package cn.lijy.demo.until.xc.Thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: cn.lijy.demo.until.xc.Thread
 * @description:
 * @author: JF1sh
 * @create: 2020-04-26 00:16
 **/
public class ProducerConsumerModel2 {

    public static void main(String[] args) {
        Storage storage =new Storage();

        Thread thread1 = new Thread(new Producer1(storage));
        Thread thread2 = new Thread(new Consumer1(storage));

        thread1.start();
        thread2.start();

    }
}

//仓库
class Storage {

    public Object block =new Object();

    private int max;
    private  ArrayList<Date> list;

    public Storage() {
        max =10;
        list =new ArrayList<Date>();
    }

    public void put(){
        synchronized (block){
            while (list.size() == max){
                try {
                    block.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Date());
            System.out.println("当前仓库中有："+list.size());
            block.notify();
        }
    }

    public void take(){
        synchronized (block){
            while (list.size() == 0){
                try {
                    block.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者正在消费："+list.get(0));
            list.remove(0);
            System.out.println("仓库还有："+list.size());
            block.notify();
        }
    }
}

//生产者
class Producer1 implements Runnable{

    public Producer1(Storage storage) {
        this.storage = storage;
    }

    private Storage storage;

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            storage.put();
        }
    }
}

//消费者
class Consumer1 implements Runnable{

    public Consumer1(Storage storage) {
        this.storage = storage;
    }

    private Storage storage;

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            storage.take();
        }
    }
}