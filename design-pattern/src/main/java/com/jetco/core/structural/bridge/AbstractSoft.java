package com.jetco.core.structural.bridge;

/**
 * <p>
 *  手机软件抽象类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-08
 */
public abstract class AbstractSoft {

    /**
     * 声明rerun方法供子类实现，同时委托给AbstractMobilePhone供其调用
     */
    public abstract void rerun();
}
