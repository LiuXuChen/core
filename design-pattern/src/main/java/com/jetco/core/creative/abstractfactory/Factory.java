package com.jetco.core.creative.abstractfactory;

/**
 * <p>
 * 工厂接口类
 * 抽象工厂模式：为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类
 * 产品一族进行扩展
 * 形容词用接口，名词用抽象类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public interface Factory {

    /**
     * 生产电脑
     * @return {@link Computer}
     */
    Computer produceComputer();

    /**
     * 生产手机
     * @return {@link Phone}
     */
    Phone producePhone();

    /**
     * 生产手表
     * @return {@link Watch}
     */
    Watch produceWatch();

}
