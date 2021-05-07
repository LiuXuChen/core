package com.jetco.core.behavioral.strategy.compare;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 狗比较年龄
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
@Slf4j
public class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

    @Override
    public void test() {
        log.info("这是测试狗按年龄来排序！");
    }
}
