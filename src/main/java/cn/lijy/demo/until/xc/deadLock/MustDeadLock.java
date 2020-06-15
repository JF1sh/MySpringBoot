package cn.lijy.demo.until.xc.deadLock;

/**
 * @program: cn.lijy.demo.until.xc.deadLock
 * @description:
 * @author: JF1sh
 * @create: 2020-06-07 23:00
 **/
public class MustDeadLock  implements Runnable {

    int flag =1;

    static Object o1 =new Object();
    static Object o2 =new Object();


    public static void main(String[] args) {
        MustDeadLock m1 = new MustDeadLock();
        MustDeadLock m2 = new MustDeadLock();

        Thread t1 = new Thread(m1);
        m1.flag=1;
        t1.start();

        Thread t2 = new Thread(m2);
        m2.flag=2;
        t2.start();


    }


    @Override
    public void run() {
        System.out.println("当前flag : " + flag);

        if (flag == 1) {
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+"我拿到了o1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"我拿到了o2");
                }
            }
        }

        if (flag == 2) {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"我拿到了o1");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"我拿到了o2");
                }
            }
        }


    }
}
