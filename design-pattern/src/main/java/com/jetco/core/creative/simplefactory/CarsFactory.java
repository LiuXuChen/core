package com.jetco.core.creative.simplefactory;

/**
 * <p>
 * 汽车工厂类
 * 简单工厂模式：一个工厂类根据传入的类型来动态决定创建哪一类产品类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class CarsFactory {

    private CarsFactory(){}

    /**
     * 根据汽车类型获取相对应的汽车
     * 设置为static的，避免类的频繁实例化，拿来即用
     * @param carType 汽车类型
     * @return car
     */
    public static Car getCar(CarType carType) {
        return carType.getConstructor().get();
    }
}
