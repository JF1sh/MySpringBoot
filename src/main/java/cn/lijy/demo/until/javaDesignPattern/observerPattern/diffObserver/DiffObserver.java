package cn.lijy.demo.until.javaDesignPattern.observerPattern.diffObserver;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer.diffObserver
 * @description: 观察接口
 * @author: JF1sh
 * @create: 2020-05-13 21:49
 **/
public interface DiffObserver {

    public void update(ConcreteDiffSubject subject);

    public void setObserverName( String name);

    public String getObserverName();

}
