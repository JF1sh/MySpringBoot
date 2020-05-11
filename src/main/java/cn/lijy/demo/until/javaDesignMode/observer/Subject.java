package cn.lijy.demo.until.javaDesignMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer
 * @description: 目标对象(被观察者) 它知道观察它的观察者，并提供注册（添加） 删除 观察者接口
 * @author: JF1sh
 * @create: 2020-05-11 22:59
 **/
public class Subject {

    // 用户保存注册的观察者对象 (哪些对象会因目标对象的改变而改变)
    private List<Observer> observers = new ArrayList<Observer>();



    /**
     *  将观察者对象添加到 注册的观察者集合中
     * @param observer 观察者对象
     */
    public void attach (Observer observer){
        observers.add(observer);
    }

    /**
     * 删除注册集合中 指定的观察者对象
     * @param observer 观察者对象
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 只有子类可以调用所以用 protected
     * 用于通知所有注册集合的所有观察者
     */
    protected void notifyObservers(){
        for(Observer ob: observers){
            //将目标对象传入 以便于观察者获取到目标的状态
            ob.update(this);
        }
    }
}
