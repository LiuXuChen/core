package com.jetco.core.creative.simplefactory;

/**
 * <p>
 * 产品接口类：汽车
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public interface Car {

    /**
     * 汽车运行
     */
    void run();

    /**
     * 汽车停止
     */
    void stop();

    /**
     * 汽车描述
     * @return string
     */
    void description();

}
