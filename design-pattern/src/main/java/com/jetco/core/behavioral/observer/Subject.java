package com.jetco.core.behavioral.observer;

/**
 * <p>
 * 发布者接口
 *
 * 观察者（发布-订阅模式）：
 * 定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。
 * 可以用来解耦。
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-21
 */
public interface Subject {

    /**
     * 添加订阅者
     * @param observer
     */
    void register(Observer observer);

    /**
     * 删除订阅者
     * @param observer
     */
    void remove(Observer observer);

    /**
     * 将消息通知所有订阅者
     * @param msg
     */
    void notifyObservers(String msg);
}
