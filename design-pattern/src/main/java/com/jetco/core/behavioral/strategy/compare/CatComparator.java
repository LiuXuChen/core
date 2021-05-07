package com.jetco.core.behavioral.strategy.compare;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 猫比较命的多少
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
@Slf4j
public class CatComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o1.getLife(), o2.getLife());
    }

    @Override
    public void test() {
        log.info("这是测试猫按命的多少来排序！");
    }
}
