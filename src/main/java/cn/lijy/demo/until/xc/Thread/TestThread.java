package cn.lijy.demo.until.xc.Thread;

/**
 * @program: cn.lijy.demo.until.xc.Thread
 * @description: 继承Thread类  实现卖票（使用3个线程）
 *
 *   继承Thread类  为单线程处理，每个线程都会去卖五张票
 *
 * @author: JF1sh
 * @create: 2020-04-12 23:33
 **/

class MyThread extends Thread{

    private int ticketsCont = 5; //火车站有五张票
    private String name;  //窗口，线程的名字



    public  MyThread(String name ){
        this.name=name;
    }

    public void  run(){
        while (ticketsCont > 0){
            ticketsCont -- ;
            System.out.println(name + "卖了一张票 剩余：" + ticketsCont);
        }
    }

        }


public class TestThread {

    public static void main(String[] args) {
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");

         mt1.start();
         mt2.start();
         mt3.start();
    }
}
