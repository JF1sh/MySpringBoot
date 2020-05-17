package cn.lijy.demo.until.java.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @program: cn.lijy.demo.until.java.reflect
 * @description: 了解泛型的本质 <泛型是为了防止我们错误输入>
 * @author: JF1sh
 * @create: 2020-05-18 00:05
 **/
public class JavaReflect4 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        ArrayList<String> list1 =new ArrayList<String>();
        list1.add("hello");

        Class a = list.getClass();
        Class b = list1.getClass();

        //反射的操作都是编译之后的，a==b 编译之后没有了泛型
        System.out.println(a == b);


        try {
            // 这样不能使用foreach进行遍历
            Method method= b.getMethod("add", Object.class);
            method.invoke(list1,1);

            System.out.println(list1.size());
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
