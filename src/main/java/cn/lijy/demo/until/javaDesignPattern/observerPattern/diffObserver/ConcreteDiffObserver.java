package cn.lijy.demo.until.javaDesignPattern.observerPattern.diffObserver;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer.diffObserver
 * @description: 观察实例
 * @author: JF1sh
 * @create: 2020-05-13 22:12
 **/
public class ConcreteDiffObserver implements DiffObserver {

    private String ObserverName;

    private  String ObserverState;


    @Override
    public void update(ConcreteDiffSubject subject) {
       ObserverState = subject.getSubjectState();

        System.out.println("我是:" + ObserverName + ",我收到了：" + ObserverState);

    }

    @Override
    public void setObserverName( String  name ) {
        ObserverName = name;
    }

    @Override
    public String getObserverName() {
        return ObserverName;
    }


    public String getObserverState() {
        return ObserverState;
    }

    public void setObserverState(String observerState) {
        ObserverState = observerState;
    }
}
