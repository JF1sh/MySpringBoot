package cn.lijy.demo.until.testDo;

import java.util.Arrays;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 使用冒泡排序
 * @author: JF1sh
 * @create: 2020-04-27 19:51
 **/
public class BubbleSort {
    final static int [] num = {1,11,23,4,33,5,2,3,88,99,34};

    public static void main(String[] args) {
        for (int i = 0; i <num.length ; i++) {
            for (int j = i; j < num.length ; j++) {
                if(num[i] > num [j]){
                    int temp;
                     temp =num[i] ;
                     num[i] =num[j];
                     num[j]=temp;
                    System.out.println("当前："+Arrays.toString(num));
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
