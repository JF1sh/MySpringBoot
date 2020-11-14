package cn.lijy.demo.until.testDo;

import java.lang.reflect.Field;

/**
 * 获取私有成员变量的值
 * 私有成员变量在静态代码块中被赋值
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            Class<Demo1> c = Demo1.class;
            Demo1 demo1 = c.newInstance();
            Field field = c.getDeclaredField("str");
            field.setAccessible(true);
            String str =(String) field.get(demo1);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
