package com.jetco.core.creative.factorymethod;

/**
 * <p>
 * 发送服务接口类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
@FunctionalInterface
public interface SenderService {

    /**
     * 发送
     */
    void send();
}
