package cn.lijy.demo.until.testDo;


import com.alibaba.druid.util.StringUtils;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 测试Java方法
 * @author: JF1sh
 * @create: 2019-11-10 14:35
 **/
public class MethodJava {


   /**
   * @Description:  使用contains 判断字符串
   * @Param: [key]
   * @return: void
   * @Author: JF1sh
   * @Date: 2019/11/10
   * @Time: 15:04
   **/
    public static boolean useContains(String key) {
        boolean status = key.contains("a");
        if(status){
            System.out.println("包含a");
        }else{
            System.out.println("不包含a");
        }
        return status;
    }


    /**
    * @Description: 使用indexof 判断一个字符串中是否包含另一个
    * @Param: [key1, key2] 
    * @return: int 
    * @Author: JF1sh 
    * @Date: 2019/11/10 
    * @Time: 15:12
    **/
    public static int useIndexOf(String key1,String key2){
        int result = key1.indexOf(key2); //key1中是否包含key2
        if(result != -1){
            System.out.println("字符串key1中包含子串“key2”"+result);
        }else{
            System.out.println("字符串key1中不包含子串“key2”"+result);
        }
        return result;
    }


    /**
    * @Description: 测试com.alibaba.druid.util.StringUtils 包中的方法 
    * @Param: [key] 
    * @return: boolean 
    * @Author: JF1sh 
    * @Date: 2019/11/12 
    * @Time: 19:20
    **/
    public static boolean useStringUntil1(String key){
        StringUtils.isNumber(key); //判断该数字是否为字符串
        StringUtils.subString(key, "a", "c",true);//tolast 表示是否为最后一个c 默认为flase(取第一个c)
        StringUtils.stringToInteger("23");//将字符串23，转换为数字23.默认去空格
        StringUtils.equalsIgnoreCase(key,"abcd");//将字符串key与abcd 进行比较是否一致，忽略大小写
        StringUtils.isEmpty(key);//判断key是否为空或者null，但不能判读空格。

        return true;
    }

    /**
    * @Description: 测试org.apache.commons.lang.StringUtils中的方法
    * @Param: [key]
    * @return: boolean
    * @Author: JF1sh
    * @Date: 2019/11/12
    * @Time: 19:33
    **/
    public static  boolean useStringUntil2(String key){
//        org.apache.commons.lang.StringUtils.isNotBlank(key);// 表示不是null不是空格·
//        org.apache.commons.lang.StringUtils.isNotEmpty(key);// 仅表示不是null,可以是空格
        int index =1;
        int idex = index == 0 ? 1:2; //三目表达式，如果index == 0 为真 则把1赋给变量，否则把2赋给变量
        return true;
    }


    public static void main(String[] args) {
//        useContains("aaaaaaaaaa");
//        useIndexOf("lijingyu","gy");
 //    useStringUnti("abcdc");


    }

}
