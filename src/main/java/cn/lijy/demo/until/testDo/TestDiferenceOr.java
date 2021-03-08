package cn.lijy.demo.until.testDo;

import org.apache.log4j.Logger;


/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 逻辑运算 ^ & | ~
 * @author: JF1sh
 * @create: 2019-11-08 16:23
 **/
public class TestDiferenceOr {

    private static Logger log = Logger.getLogger(TestDiferenceOr.class);


    /**
     * ^  按位异或运算
     * 运算方式：两个数的二进制码进行对比，  相同取 0 ， 相反取 1 。
     * <p>
     * 概念：两个操作数经过位的异或运算后，会得到一个新数。 此数与任意一个操作数进行异或运算，会得到另一个操作数
     * <p>
     * 作用：中间数的作用
     * <p>
     * 结果：可以用来交换两个基本数据类型的变量的内容
     * <p>
     * 基本数据类型: byte short int long float double  boolean
     */
    public static void test1() {
        log.info("^  按位异或运算");
        int num1 = 50;
        int num2 = 14;

        num1 = num1 ^ num2;
        System.out.println("第一次异或运算后 num1:" + num1);
        num2 = num1 ^ num2;
        System.out.println("第一次异或运算后 num2:" + num2);
        num1 = num1 ^ num2;
        System.out.println("第二次异或运算后 num1:" + num1);

        System.out.println("当前 num1 :" + num1);
        System.out.println("当前 num2 :" + num2);
    }

    /**
     * & 按位与
     * <p>
     * 运算方式：将两个数的二进制码进行对比，两个都为 1 才为 1
     * 8：1000
     * 9：1001
     * 输出结果： 1000
     * <p>
     * 作用：可以将 1 与其他数进行相比 来判断该数的基偶性。
     * 可以判断两个布尔值 是否同时为真。1 为真 0 为假
     */

    public static void test2() {
        log.info("& 按位与 运算");

        int num1 = 1;
        int num2 = 7;

        System.out.println(num1 & num2);

    }


    /**
     * | 按位或
     * <p>
     * 运算方式： 当两个操作数的二进制码 只要有一个为真（1）的时候则为真（1）
     * <p>
     * 8: 1000
     * 9: 1001
     * <p>
     * 输出结果： 1001
     */
    public static void test3() {
        log.info("| 按位或 运算");

        int num1 = 1;
        int num2 = 7;

        System.out.println(num1 | num2);

    }


    /**
     * 位运算 >> <<   >>>
     *
     * 运算方式 >>: 将二进制吗向右移动
     * 运算方式 <<: 向左移动
     * 运算方式 >>>:
     *
     * */
    public static void test4(){

    }


    public static void main(String[] args) {
//        test1();//测试两个数的异或运算 ^
//
//        test2();//测试两个数的按位与  &
//
//        test3();//测试两个数的按位或  |

//        System.out.println((8 >> 3));
//        System.out.println((4 >> 3));

        System.out.println(-1L ^ (-1L << 3L));
        System.out.println(-1L ^ (-1L << 10L));
        System.out.println(-1L ^ (-1L << 10L));

        System.out.println(12 ^ 7);
        System.out.println(3L);
    }
}
