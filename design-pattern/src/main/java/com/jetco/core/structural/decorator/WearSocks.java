package com.jetco.core.structural.decorator;

/**
 * <p>
 * 穿袜子
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public class WearSocks extends BaseWear {

    protected WearSocks(IComponent component) {
        super(component);
    }

    @Override
    public String description(String msg) {
        return super.description(msg);
    }

    @Override
    public String wear() {
        return "穿袜子！";
    }
}
