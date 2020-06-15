package cn.lijy.demo.until.testDo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: cn.lijy.demo.until.xc
 * @description:
 * @author: JF1sh
 * @create: 2020-03-19 17:31
 **/
public class test {

     static int a =0;

    public void say(String name ){
        for(int i=0;i<5;i++){
            System.out.println(i+"-"+name);
        }
    }


    /**判断是否超过24小时
     *
     * @param date1
     * @param date2
     * @return boolean
     * @throws Exception
     */

    public static boolean judgmentDate(String date1, String date2) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");

        Date start = sdf.parse(date1);

        Date end = sdf.parse(date2);

        long cha = end.getTime() - start.getTime();

        if(cha<0){
            return false;
        }
        double result = cha * 1.0 / (1000 * 60 * 60);
        if(result<=24){
            return true;
        }else{
            return false;
        }

    }


    @Test
    public void say(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date();
        System.out.println(sdf.format(date));

    }
}
