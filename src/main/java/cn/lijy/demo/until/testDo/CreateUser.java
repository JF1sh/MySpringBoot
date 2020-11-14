package cn.lijy.demo.until.testDo;


import java.util.Random;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 随机生成用户信息
 * @author: JF1sh
 * @create: 2020-05-13 16:11
 **/
public class CreateUser {
    final static char[] digits1={'0','1','2','3','4','5','6','7','8','9'}; //code and loginName

    final static char[] digits2={'0','1','2','3','4','5','6','7','8','9','q','w','e',
            'r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c',
            'v','b','n','m','^','&','#'};//password

    final static char[] digits3={'路','索','隆','键','的','去','飞','你','胖','跳','数','啊','这','写','草','吧','你','哥','了','哦','饿'};//name

    /**
     * 为人员信息生产随机密码
     * @param size
     * @return
     */
    public static String CreateUserInfo(int size, int flag){
        char[] digits={};
        if (flag ==1){
            digits = digits1;
        }else if(flag ==2){
            digits=digits2;
        }else {
            digits=digits3;
        }
        Random random=new Random();
        char[] cs =new char[size];
        for (int i = 0; i <cs.length ; i++) {
            cs[i]=digits[random.nextInt(digits.length)];
        }
        return new String(cs);
    }

}
