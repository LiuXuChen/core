package com.jetco.core.structural.bridge;

/**
 * <p>
 * 手机抽象类
 * 桥接模式：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-08
 */
public abstract class AbstractMobilePhone {

    protected AbstractSoft abstractSoft;

    protected AbstractMobilePhone(AbstractSoft abstractSoft) {
        this.abstractSoft = abstractSoft;
    }

    /**
     * 允许各种软件
     */
    public abstract void run();


}
