package com.jetco.core.behavioral.strategy.compare;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 猪比较重量
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
@Slf4j
public class PigComparator implements Comparator<Pig> {

    @Override
    public int compare(Pig o1, Pig o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }

    @Override
    public void test() {
        log.info("这是通过比较猪的重量来排序！");
    }
}
