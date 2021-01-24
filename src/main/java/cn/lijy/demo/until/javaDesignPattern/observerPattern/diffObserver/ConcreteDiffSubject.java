package cn.lijy.demo.until.javaDesignPattern.observerPattern.diffObserver;

/**
 * @program: cn.lijy.demo.until.javaDesignMode.observer.diffObserver
 * @description: 目标类
 * @author: JF1sh
 * @create: 2020-05-13 21:56
 **/
public class ConcreteDiffSubject extends DiffSubject {

    private String subjectState;


    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }


    @Override
    protected void notifyObservers() {
        for (DiffObserver dob : observers) {
            //if (dob.getObserverName().equals("li-1")) {
                dob.update(this);
           // }
        }
    }
}
