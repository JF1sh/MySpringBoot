package cn.lijy.demo.until.UnitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @program: cn.lijy.demo.until.UnitTest
 * @description:
 * @author: JF1sh
 * @create: 2020-03-10 17:59
 **/
@RunWith(BlockJUnit4ClassRunner.class)
public class test {

    private static  int  max = 3;

    @Test
    public void get(){
        System.out.println("ok");
    }


    @Test
    public void say(){
        int min =0;
        do {
            min++;
            System.out.println(min);
        }while (min <= this.max);
        System.out.println();
        int mid= 0;
        while (mid < max){
            System.out.println(mid);
            mid++;
        }
    }

}
