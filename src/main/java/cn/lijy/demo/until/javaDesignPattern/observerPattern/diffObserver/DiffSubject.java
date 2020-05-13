package cn.lijy.demo.until.javaDesignPattern.observerPattern.diffObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer.disObserver
 * @description: 区别对待观察者，使观察者收到不同 的消息
 * @author: JF1sh
 * @create: 2020-05-13 21:45
 **/
public abstract class DiffSubject {

    public List<DiffObserver> observers = new ArrayList<DiffObserver>();
    ;

    public void addObserver(DiffObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DiffObserver observer) {
        observers.remove(observer);
    }

    //因为需要通知的对象不确定，所有定为抽象方法，让子类去实现具体的通知逻辑
    protected abstract void notifyObservers();
}
