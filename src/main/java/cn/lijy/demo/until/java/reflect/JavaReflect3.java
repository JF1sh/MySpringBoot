package cn.lijy.demo.until.java.reflect;

import java.lang.reflect.Method;

/**
 * @program: cn.lijy.demo.until.java.reflect
 * @description: 方法的反射应用
 * @author: JF1sh
 * @create: 2020-05-17 23:10
 **/
public class JavaReflect3 {

    public static void main(String[] args) {
        // 1,利用发射调用类方法：首先要获取类的类类型
        ReflectA reflectA =new ReflectA();
        Class c =reflectA.getClass();

        // 2,利用类的类类型 反射调用ReflectA类的方法
        try {
            //c.getDeclaredMethod获取自己声明的方法
            //c.getMethod 获取公有方法
            Method method= c.getDeclaredMethod("print2",int.class,int.class);
            method.invoke(reflectA,1,2);

            System.out.println("=======================================");

            Method method2= c.getDeclaredMethod("print1", String.class);
            // true的值表示反射对象应该在使用时抑制Java语言访问检查。
            method2.setAccessible(true);
            method2.invoke(reflectA,"ll");

            System.out.println("=======================================");

            Method method1= c.getDeclaredMethod("print3", String.class, String.class);
            method1.invoke(reflectA,"ABC","abc");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}

class ReflectA{

    private void print1(String a){
        System.out.println("调用：私有无参方法方法"+a);
    }

    public void print2(int a, int b){
        System.out.println("调用：公有参数为int的方法"+">>>>>>>>"+a+b);
    }

    protected static void print3(String a , String b ){

        //大小写转换
        System.out.println("调用：被保护的静态方法>>>>>>>>" + a.toLowerCase() + "-----" + b.toUpperCase());
    }


}
