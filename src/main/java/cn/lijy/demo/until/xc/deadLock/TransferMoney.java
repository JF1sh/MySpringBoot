package cn.lijy.demo.until.xc.deadLock;

/**
 * @program: cn.lijy.demo.until.xc.deadLock
 * @description: 转账
 * 转账需要两把锁，锁住自己和对方账号进行转账
 * @author: JF1sh
 * @create: 2020-06-10 23:00
 **/
public class TransferMoney implements Runnable {

    int flag = 1;

    static Account a = new Account(500);
    static Account b = new Account(500);

    public static void main(String[] args) throws InterruptedException {
        TransferMoney t1 = new TransferMoney();
        TransferMoney t2 = new TransferMoney();


        t1.flag = 1;
        Thread r1 = new Thread(t1);
        r1.start();

        t2.flag = 2;
        Thread r2 = new Thread(t2);
        r2.start();

        r1.join();
        r2.join();

        System.out.println("a的余额：" + a.balance);
        System.out.println("b的余额：" + b.balance);
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 100);
        }
        if (flag == 2) {
            transferMoney(b, a, 200);
        }
    }

    /**
     *  先锁自己账户 再锁转出账户。 容易造成死锁
     * @param from 转出账户
     * @param to   转入账户
     * @param amount  转出金额
     */
    public static void transferMoney(Account from, Account to, int amount) {

        synchronized (from) {
            //Thread.sleep(100); 当打开注释时，会发生死锁，因为竞争锁时线程在任何一步都会被抢占
            synchronized (to) {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账，转了" + amount + "元");
            }
        }
    }




    static class Account {
        int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }

}


