package cn.lijy.demo.until.javaDesignPattern.observerPattern.diffObserver;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer.diffObserver
 * @description:
 * @author: JF1sh
 * @create: 2020-05-13 22:17
 **/
public class Test {


    public static void main(String[] args) {
        ConcreteDiffSubject subject =new ConcreteDiffSubject();

        ConcreteDiffObserver observer1 = new ConcreteDiffObserver();
        observer1.setObserverName("li-1");
        ConcreteDiffObserver observer2 = new ConcreteDiffObserver();
        observer2.setObserverName("li-2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setSubjectState("gun");

    }
}
