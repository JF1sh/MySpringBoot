package cn.lijy.demo.until.httpUtils.httpDemo;

import java.util.ArrayList;

/**
 * @program: cn.lijy.demo.until.httpUtils.httpDemo
 * @description:
 * @author: JF1sh
 * @create: 2020-07-10 15:28
 **/
public class HttpUtilsTest {


    public static void main(String[] args) {
        ArrayList<String>  list = new ArrayList<>();
        list.add("SID.list");
        TestBuilder.executor(list);

    }
}
