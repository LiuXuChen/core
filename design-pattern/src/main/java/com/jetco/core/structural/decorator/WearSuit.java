package com.jetco.core.structural.decorator;

/**
 * <p>
 * 穿西装
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public class WearSuit extends BaseWear {

    protected WearSuit(IComponent component) {
        super(component);
    }

    @Override
    public String description(String msg) {
        return super.description(msg);
    }

    @Override
    public String wear() {
        return "穿西装！";
    }
}
