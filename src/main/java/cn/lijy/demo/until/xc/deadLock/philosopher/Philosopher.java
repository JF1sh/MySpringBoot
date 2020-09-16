package cn.lijy.demo.until.xc.deadLock.philosopher;

/**
 * @program: cn.lijy.demo.until.xc.deadLock
 * @description: 五个哲学家 五只筷子。 只有拿到两只筷子时才能吃饭
 * 发生死锁的原因：每个人都拿起了左手的筷子。尝试去获取右边的筷子。
 * 解决方法(打破死锁的任意条件):
 * @author: JF1sh
 * @create: 2020-06-22 22:36
 **/
public class Philosopher implements Runnable {

    private Object left;
    private Object right;

    public Philosopher(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            try {
                doAction("Thinking");
                synchronized (left) {
                    doAction("拿起 left");
                    synchronized (right) {
                        doAction("拿起 right");
                        doAction("Eating");
                        doAction("放下 right");
                    }
                    doAction("放下 left");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doAction(String thing) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "-" + thing);
        Thread.sleep((long) (Math.random() * 10));
    }


    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];//五个哲学家
        Object[] chopsticks = new Object[philosophers.length];//五只筷子

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

       // mustDeadLock(philosophers,chopsticks);
        method1(philosophers,chopsticks);



    }

    /**
     *  必然死锁
     * @param philosophers 哲学家
     * @param chopsticks   筷子
     */
    private static void mustDeadLock(Philosopher[] philosophers,Object[] chopsticks){
        for (int i = 0; i < philosophers.length; i++) {
            Object left = chopsticks[i];
            Object right = chopsticks[(i + 1) % chopsticks.length];
            philosophers[i] = new Philosopher(left, right);
            new Thread(philosophers[i], "哲学家" + (i + 1) + "号:").start();
        }
    }

    /**
     *  解决方法1： 改变任意一个哲学家拿起筷子的顺序 (不形成循环等待)
     * @param philosophers
     * @param chopsticks
     */
    private static void method1(Philosopher[] philosophers,Object[] chopsticks){
        for (int i = 0; i < philosophers.length; i++) {
            Object left = chopsticks[i];
            Object right = chopsticks[(i + 1) % chopsticks.length];
            if(i == 2){
                philosophers[i] = new Philosopher(right, left);
            }else {
                philosophers[i] = new Philosopher(left, right);
            }
            new Thread(philosophers[i], "哲学家" + (i + 1) + "号:").start();
        }
    }

}
