package com.jetco.core.behavioral.observer;

/**
 * <p>
 * 订阅者接口
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-21
 */
public interface Observer {

    /**
     * 接受通知消息
     * @param msg
     */
    void receive(String msg);
}
