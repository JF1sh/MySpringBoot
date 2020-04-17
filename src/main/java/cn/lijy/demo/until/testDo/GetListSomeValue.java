package cn.lijy.demo.until.testDo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringBoot_Demo
 * @description: 获取集合中固定的值，直至取完。
 * @author: JF1sh
 * @create: 2019-11-05 16:37
 **/
public class GetListSomeValue {

    /**
     * @Description:  每次取10个值
     * @Param:  集合的大小   总共分成了 keyIndex 份
     * @return:
     * @Author: JF1sh
     * @Date: 2019/11/5
     * @Time: 16:24
     **/
    public static void  getDate(List<String> list){
        int listSize= list.size();
        int toIndex= 10;//每次所要取的数
        int keyIndex=0;
        for (int i = 0; i < listSize; i+=10) {
            if (i+10 > listSize) {
                toIndex=listSize-i;
            }
            List newList = list.subList(i,i+toIndex);
            System.out.println(newList);
            keyIndex++;
        }
        System.out.println(keyIndex);
    }

    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        for (int i = 0; i <57 ; i++) {
            list.add("JF1sh"+i);
        }
        getDate(list);
    }
}
