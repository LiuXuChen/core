package com.jetco.core.creative.abstractfactory;

/**
 * <p>
 * 华为工厂类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class HuaWeiFactory implements Factory {

    @Override
    public Computer produceComputer() {
        return new HuaWeiComputer();
    }

    @Override
    public Phone producePhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Watch produceWatch() {
        return new HuaWeiWatch();
    }
}
