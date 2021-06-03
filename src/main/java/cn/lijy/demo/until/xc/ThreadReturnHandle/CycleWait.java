package cn.lijy.demo.until.xc.ThreadReturnHandle;

/**
 * 1,主线程循环等待 处理线程返回值
 * 缺点：不确定循环次数，且循环等待不好编写
 * 2,使用Thread.join() ,使得当前线程优先执行，其他线程陷入等待。让子线程执行完后，主线程再执行
 * 缺点：粒度不够细。
 */
public class CycleWait  implements Runnable{
    private String value;
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value ="We get data now";
    }

    public static void main(String[] args) {
        CycleWait cycleWait = new CycleWait();
        Thread thread = new Thread(cycleWait);
        thread.start();
//        while (cycleWait.value == null){ //主线程循环等待，防止主线程运行完时 子线程还未对变量赋值
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            thread.join();//当前线程优先执行，其他线程陷入等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cycleWait.value);//获取线程的赋值
    }
}
