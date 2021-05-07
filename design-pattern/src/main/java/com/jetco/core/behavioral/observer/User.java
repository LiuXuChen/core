package com.jetco.core.behavioral.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 用户的抽象（具体订阅者）
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-21
 */
@Slf4j
public class User implements Observer {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receive(String msg) {
        log.info("{}接收到通知消息：{}", name, msg);
    }
}
