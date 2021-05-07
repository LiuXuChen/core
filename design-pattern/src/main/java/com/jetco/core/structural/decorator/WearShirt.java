package com.jetco.core.structural.decorator;

/**
 * <p>
 * 穿衬衫
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public class WearShirt extends BaseWear {

    public WearShirt(IComponent component) {
        super(component);
    }

    @Override
    public String description(String msg) {
        return super.description(msg);
    }

    @Override
    public String wear() {
        return "穿衬衫！";
    }
}
