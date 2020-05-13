package cn.lijy.demo.until.javaDesignPattern.observerPattern;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer
 * @description: 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author: JF1sh
 * @create: 2020-05-11 23:31
 **/
public class ConcreteObject implements Observer {

    //观察者状态
    private  String observerState;

    /**
     * 获取目标状态，同步到观察者状态中
     * @param subject 传入目标对象，获取目标对象的状态
     */
    @Override
    public void update(Subject subject) {
     observerState =  ((ConcreteSubject)subject).getSubjectState();
    }
}
