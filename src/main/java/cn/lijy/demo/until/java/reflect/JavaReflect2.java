package cn.lijy.demo.until.java.reflect;

import cn.lijy.demo.until.testDo.UDPSocketMgr;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.SocketException;

/**
 * @program: cn.lijy.demo.until.java
 * @description: Class类的基本API
 * @author: JF1sh
 * @create: 2020-05-15 22:37
 **/
public class JavaReflect2 {

    public static void main(String[] args) throws SocketException {
        UDPSocketMgr udpSocketMgr =new UDPSocketMgr();
        ClassUntil1(udpSocketMgr);
    }

    /**
     * 获取类信息
     * @param object
     */
    private static void ClassUntil1(Object object){

        //object为一个具体的实例
        Class c = object.getClass(); //传递哪个子类对象 c就是该子类的类类型

        //获取类的名称
        System.out.println("类的全路径是："+c.getName());
        System.out.println("类的名称是:"+c.getSimpleName());


        /**
         * Method类 方法的对象
         * 一个成员方法为一个 Method对象
         * c.getMethods()； 获取所有public的函数，包括从父类继承而来的
         * c.getDeclaredMethods(); 是获取自己声明的方法，不问访问权限
         */
        Method[] mc = c.getMethods();
        for (int i = 0; i <mc.length ; i++) {
            //得到返回值的类类型  "String.class,   int.Class"
            Class returnType=mc[i].getReturnType();
            System.out.println("返回值类型："+returnType.getName());

            //得到方法名
            System.out.print("方法名为"+mc[i].getName()+"(");

            //得到参数列表类型的类类型，"String.class,   int.Class"
            Class[] parameterTypes=mc[i].getParameterTypes();
            for(Class paras: parameterTypes){
                //得到参数
                System.out.print(paras.getName()+",");
            }
            System.out.println(")");
        }

    }

    /**
     * 获取类的成员变量
     */
    private static void ClassUntil2(Object object){

        Class c =object.getClass();

        /**
         *成员变量也是对象
         * 是在 java.lang.reflect.Filed
         * Filed种封装了关于成员变量的操作
         * c.getFields(); 获取public 成员变量信息
         *   c.getDeclaredFields(); 获取自己声明的成员变量的信息
         */

        Field[] fields=  c.getDeclaredFields();
        for (Field field:fields){
             //获得成员变量的类类型  String.class
            Class cf= field.getType();
            //获得成员变量的类型
            System.out.println("成员变量的类型： "+cf.getName());

            System.out.println("成员变量的名字："+field.getName());
        }
    }

    /**
     * 获取构造函数的信息
     * @param object
     */
    private static void ClassUntil3(Object object) {

        Class c = object.getClass();

        /**
         * 构造函数也是对象
         * c.getConstructors(); 获取所有公有构造方法
         * c.getConstructors(); 获取自己申明的
         */
        Constructor[] constructors= c.getConstructors();

        for (Constructor ct:constructors){
            System.out.println(""+ct.getName() + "(");
        }
    }


    }
