package cn.lijy.demo.until.xc.deadLock;

/**
 * @program: cn.lijy.demo.until.xc.deadLock
 * @description:  解决方法1 使用一致的顺序来解决 转账引起的死锁
 *  始终先获取hash值小的锁 再去获取大的锁  如果hash值相等 再加一把锁
 * @author: JF1sh
 * @create: 2020-06-15 23:00
 **/
public class TransferMoney3 implements Runnable {


    int flag1 = 1;

    static Account1 a1 = new Account1(500);
    static Account1 b1 = new Account1(500);

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney3 t1 = new TransferMoney3();
        TransferMoney3 t2 = new TransferMoney3();


        t1.flag1 = 1;
        Thread r1 = new Thread(t1);
        r1.start();

        t2.flag1 = 2;
        Thread r2 = new Thread(t2);
        r2.start();

        r1.join();
        r2.join();

        System.out.println("a的余额：" + a1.balance);
        System.out.println("b的余额：" + b1.balance);
    }

    @Override
    public void run() {
        if (flag1 == 1) {
            transferMoney(a1, b1, 100);
        }
        if (flag1 == 2) {
            transferMoney(b1, a1, 200);
        }
    }

    /**
     * 先锁自己账户 再锁转出账户。 容易造成死锁
     *
     * @param from   转出账户
     * @param to     转入账户
     * @param amount 转出金额
     */
    public static void transferMoney(Account1 from, Account1 to, int amount) {

        class Helper {
            public void transferMoney1() {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账，转了" + amount + "元");
            }
        }
        int fromHash = System.identityHashCode(from); //转出账号的hash值
        int toHash = System.identityHashCode(to); //转入账号的hash值

        //使用hash来控制锁的获取顺序 始终先获取小的再获取大的
        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    new Helper().transferMoney1();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    new Helper().transferMoney1();
                }
            }
        } else {
            synchronized (obj) {
                synchronized (to) {
                    synchronized (from) {
                        new Helper().transferMoney1();
                    }
                }
            }
        }

    }


    static class Account1 {
        int balance;

        public Account1(int balance) {
            this.balance = balance;
        }
    }


}
