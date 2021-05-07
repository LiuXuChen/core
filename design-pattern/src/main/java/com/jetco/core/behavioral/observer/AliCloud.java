package com.jetco.core.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 具体发布者（阿里云）
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-21
 */
public class AliCloud implements Subject {

    /**
     * 存放所有订阅者
     */
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        synchronized (this) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public synchronized void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for (Observer observer : observers) {
            observer.receive(msg);
        }
    }

    /**
     * 改变后进行消息通知
     */
    public void change(String msg) {
        this.notifyObservers(msg);
    }
}
