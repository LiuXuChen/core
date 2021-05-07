package com.jetco.core.structural.decorator;

/**
 * <p>
 * 打领带
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public class WearTie extends BaseWear {

    protected WearTie(IComponent component) {
        super(component);
    }

    @Override
    public String description(String msg) {
        return super.description(msg);
    }

    @Override
    public String wear() {
        return "打领带！";
    }
}
