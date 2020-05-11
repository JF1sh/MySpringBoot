package cn.lijy.demo.until.javaDesignMode.observer;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer
 * @description: 具体的目标对象，负责把有关状态存入到相应的观察对象中
 * @author: JF1sh
 * @create: 2020-05-11 23:02
 **/
public class ConcreteSubject extends Subject {

    //目标对象状态
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        //当状态改变时通知观察者 调用父类方法
        this.notifyObservers();
    }


}
