package com.jetco.core.creative.factorymethod;

/**
 * <p>
 * 工厂接口类
 * 工厂方法模式：核心工厂类不再负责所有产品的创建，而是将具体创建的工作交给子类去完成
 * 产品维度扩展
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
@FunctionalInterface
public interface Factory {

    /**
     * 获取具体工厂类
     * @return {@link SenderService}
     */
    SenderService getSenderService();
}
