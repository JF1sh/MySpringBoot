package cn.lijy.demo.until.java.regexp;

import org.junit.Test;

/**
 * @program: cn.lijy.demo.until.java.regexp
 * @description: 正则使用
 * @author: JF1sh
 * @create: 2020-08-11 22:46
 **/
public class UseRegexp {

    @Test
    public void execute(){
        String digit="123asd123asd";
        String digit1="123123123123";
        String digit2="223123123123";
        String digit3="asdqwdasdasd";

        String regexp2="^[0-9]\\d*";//0-9开头 不限位数的纯数字
        String regexp="^[0-9](.*?)[a-z]$"; //以数字开头，以字母结尾，(.*?)中间无论多少个
        String regexp1="\\D*"; //非数字的开头，不限位数的非数字

        System.out.println(digit.matches(regexp));
        System.out.println(digit1.matches(regexp2));
        System.out.println(digit2.matches(regexp2));
        System.out.println(digit3.matches(regexp2));

    }


    @Test
    public void execute1(){

        String phone="13992337353";
        String phone2="16992337353";
        String regExp="^1[358]\\d{9}"; //以1开头第二位是358，后面匹配9位纯数字 {9,} 表示至少出现9次

        System.out.println(phone.matches(regExp));
        System.out.println(phone2.matches(regExp));

    }
}
