package cn.lijy.demo.until.javaDesignPattern.observerPattern;

/**
 * 观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {
    /**
     * 更新接口
     * @param subject 传入目标对象，获取目标对象的状态
     */
    void update(Subject subject);
}
