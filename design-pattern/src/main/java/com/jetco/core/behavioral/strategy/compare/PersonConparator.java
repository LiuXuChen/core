package com.jetco.core.behavioral.strategy.compare;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 人比较身高
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
@Slf4j
public class PersonConparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getHeight(), o2.getHeight());
    }

    @Override
    public void test() {
        log.info("这是通过测试人的身高来排序！");
    }
}
