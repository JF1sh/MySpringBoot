package cn.lijy.demo.until.javaDesignPattern.singletonPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignPattern.singletonPattern
 * @description:  枚举法 单例模式 (推荐使用)
 * @author: JF1sh
 * @create: 2020-05-26 23:20
 **/
public enum  Singleton8_KY_TJ {
    INSTANCE;

    public void whatEver(){
        System.out.println("随便你干啥");
    }

}

class TestS8{

    public static void main(String[] args) {

        //调用枚举的单例
        Singleton8_KY_TJ.INSTANCE.whatEver();
    }

}


/**
 * 枚举是最好的单例写法
 * 1：写法简单
 * 2: 线程安全有保障
 * 3：避免反序列化/发射 破环单例
 *
 *
 * */