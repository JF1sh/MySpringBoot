package cn.lijy.demo.until.java.reflect;

/**
 * @program: cn.lijy.demo.until.java
 * @description:
 * @author: JF1sh
 * @create: 2020-05-15 21:46
 **/
public class JavaReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //Fool 的实例对象
        Fool fool = new Fool();

        //Fool这个类也是个实例对象
        //任何一个类都是Class的实例对象，这个实例对象有三种表达方式

        //第一种表示方法 ----> 任何一个类都有一个隐含的静态成员变量
        Class c1 = Fool.class;

        //第二种表示方法 ----> 已知该类的对象 通过getClass() 获取
        Class c2 = fool.getClass();

        // c1 / c2 表示了Fool的类 类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        // 第三种表示方法：
        Class c3 =null;
        c3 = Class.forName("cn.lijy.demo.until.java.reflect.Fool");

        System.out.println(c1 == c3);

        //我们可以通过Fool的类类型创建该类的实例对象 --> 通过c1 or c2 or c3 类的类类型 创建Fool的实例
        Fool fool1 = (Fool) c1.newInstance(); //前提是需要无参的构造函数
        fool1.say();


    }
}

class Fool{

    public void say(){
        System.out.println("ok");
    }


}