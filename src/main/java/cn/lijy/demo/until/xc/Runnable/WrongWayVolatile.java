package cn.lijy.demo.until.xc.Runnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: cn.lijy.demo.until.xc.Runnable
 * @description: volatile 停止线程的局限性 (当面对长时间阻塞时 无法唤醒线程 导致了永久等待)
 * <p>
 * 当陷入阻塞的时候，volatile 是无法停止线程的。(生产者消费者模式)
 * 生产者生产速度很快，消费者的消费速度很慢。
 * <p>
 * 当阻塞队列满了后，生产者会停止生产，等待消费者消费。消费者则反
 * <p>
 * 这种方式使用volatile会使线程陷入永久等待
 * <p>
 * 正确方式: 使用interrupt() 配合 Thread.currentThread().isInterrupted() 来停止线程
 * <p>
 * 内部类实例化：如果是非静态的 需要它的外部类先实例化再去点new内部类
 * @author: JF1sh
 * @create: 2020-04-22 23:42
 **/
public class WrongWayVolatile {

    public static void main(String[] args) throws InterruptedException {

        //实例化仓库 指定仓库容量
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

        //创建生产者 (需要一个实例化的仓库)
        Producer producer = new Producer(queue);

        //创建线程 (需要一个Runnable 对象)
        Thread thread = new Thread(producer);

        thread.start();
        Thread.sleep(1000);

        //实现消费者 (与生产者使用同一个仓库)
        Consumer consumer = new Consumer(queue);

        while (consumer.needCons()) {
            //如果需要 消费者从仓库中消费掉一个
            System.out.println("消费者：消费了" + consumer.storage.take());
            //消费者消费耗时100ms
            Thread.sleep(100);
        }
        System.out.println("消费不需要更多数据了 END");

        //一旦消费者不需要更多数据就应该停止生产
        producer.flag = true;
        //thread.interrupt();

    }
}

//生产者类
class Producer implements Runnable {
    volatile boolean flag = false;

    //生产队列 以便于消费者可以取
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override //每找到一个100的倍数就放到阻塞队列中
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !flag) {
                if (num % 100 == 0) {
                    System.out.println("生产者：把" + num + "被放入仓库");
                    storage.put(num); //仓库放满会进行阻塞。volatile 需要在循环开始进行判断，
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止运行");
        }
    }
}

//消费者类
class Consumer {
    //消费队列  消费者取生产者的仓库
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    //消费者需要消费
    public boolean needCons() {
        //Math.random() 随机生产一个小于1的数字
        if (Math.random() > 0.95) {
            return false;
        } else {
            return true;
        }
    }
}