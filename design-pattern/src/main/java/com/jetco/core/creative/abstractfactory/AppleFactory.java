package com.jetco.core.creative.abstractfactory;

/**
 * <p>
 * 苹果工厂类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class AppleFactory implements Factory {

    @Override
    public Computer produceComputer() {
        return new AppleComputer();
    }

    @Override
    public Phone producePhone() {
        return new ApplePhone();
    }

    @Override
    public Watch produceWatch() {
        return new AppleWatch();
    }
}
