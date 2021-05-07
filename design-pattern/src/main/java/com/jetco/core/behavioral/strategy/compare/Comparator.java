package com.jetco.core.behavioral.strategy.compare;

/**
 * <p>
 * 比较器策略接口
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
@FunctionalInterface
public interface Comparator<T> {

    /**
     * 比较
     * @param o1 对象一
     * @param o2 对象二
     * @return -1，0，1
     */
    int compare(T o1, T o2);

    /**
     * 测试比较器
     */
    default void test() {
        System.out.println("测试比较器！");
    }
}
