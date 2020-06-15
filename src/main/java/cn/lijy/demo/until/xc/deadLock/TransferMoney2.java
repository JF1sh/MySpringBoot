package cn.lijy.demo.until.xc.deadLock;

import java.util.Random;

/**
 * @program: cn.lijy.demo.until.xc.deadLock
 * @description: 多人同时转账，根据墨菲定律依然会发生死锁。一旦一人发生死锁就会造成环形死锁链路
 * 可以通过一致的锁获取顺序 (通过锁的hash值大小定义顺序)来解决此类问题
 *
 * 避免策略  通过换序
 * @author: JF1sh
 * @create: 2020-06-15 22:13
 **/
public class TransferMoney2 {

    private static final int NUM_ACCOUNT = 500; //账户数量
    private static final int NUM_MONEY = 1000; //每个账户的钱数
    private static final int NUM_ITERATIONS = 1000000; //交易次数
    private static final int NUM_THREADS = 20; //多少个账户进行转账

    public static void main(String[] args) {
        Random random = new Random();
        TransferMoney3.Account1[] accounts = new TransferMoney3.Account1[NUM_ACCOUNT]; //有多个账户
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new TransferMoney3.Account1(NUM_MONEY);//每个账户拥有1000元
        }
        class TransferThread extends Thread{
            @Override
            public void run() {
                for (int i = 0; i <NUM_ITERATIONS ; i++) {
                    int fromAcct = random.nextInt(NUM_ACCOUNT); //取得一个随机数不超过账户数量 从哪里转
                    int toAcct = random.nextInt(NUM_ACCOUNT); //取得一个随机数不超过账户数量   转到哪里
                    int amount = random.nextInt(NUM_MONEY); //随机的转账金额
                    TransferMoney3.transferMoney(accounts[fromAcct],accounts[toAcct],amount);
                }
            }
        }

        for (int i = 0; i <NUM_THREADS; i++) {
            new TransferThread().start();
        }
        
    }
}
