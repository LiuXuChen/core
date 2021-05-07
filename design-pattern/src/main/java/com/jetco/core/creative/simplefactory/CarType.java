package com.jetco.core.creative.simplefactory;

import java.util.function.Supplier;

/**
 * <p>
 * 汽车类型
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public enum CarType {
    /**
     * 汽车类型的枚举
     */
    BENZ(Benz::new),
    BMW(BMW::new),
    AUDI(Audi::new);

    private final Supplier<Car> constructor;

    CarType(Supplier<Car> constructor) {
        this.constructor = constructor;
    }

    public Supplier<Car> getConstructor() {
        return this.constructor;
    }
}
