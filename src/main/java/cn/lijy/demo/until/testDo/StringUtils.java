package cn.lijy.demo.until.testDo;

import java.util.Random;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description:
 * @author: JF1sh
 * @create: 2019-12-04 09:23
 **/
public class StringUtils {

    final static char[] digits={'0','1','2','3','4','5','6','7','8','9','q','w','e',
          'r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c',
            'v','b','n','m','^','&','#'};

    /**
     * 随机生成id
     * @param size
     * @return
     */
    public static String uuid(int size){
        Random random=new Random();
        char[] cs =new char[size];
        for (int i = 0; i <cs.length ; i++) {
            cs[i]=digits[random.nextInt(digits.length)];
        }
        return new String(cs);
    }


    public static void main(String[] args) {
        System.out.println(uuid(33));
    }
}
