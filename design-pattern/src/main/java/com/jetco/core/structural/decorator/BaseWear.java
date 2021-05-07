package com.jetco.core.structural.decorator;

/**
 * <p>
 * 抽象装饰类,实现类组件接口
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public abstract class BaseWear implements IComponent {

    protected final IComponent component;

    protected BaseWear(IComponent component) {
        this.component = component;
    }

    @Override
    public String description(String msg) {
        return component.description(msg);
    }

    /**
     * 穿什么
     * @return string
     */
    public abstract String wear();

}
