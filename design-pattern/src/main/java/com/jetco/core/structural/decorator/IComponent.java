package com.jetco.core.structural.decorator;

/**
 * <p>
 * 组件对象接口类
 *
 * 起床穿啥
 *
 * 装饰器模式：在原有基础上进行装饰，动态给对象增加功能，比如JDk中对InputStream做的各种增强
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public interface IComponent {

    /**
     * 起床后对穿什么进行描述
     * @param msg 描述内容
     * @return string
     */
    String description(String msg);
}
