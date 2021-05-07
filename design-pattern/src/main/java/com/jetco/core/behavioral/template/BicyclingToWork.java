package com.jetco.core.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 骑车上班
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-22
 */
@Slf4j
public class BicyclingToWork extends AbstractWork {

    @Override
    public void commute() {
        log.info("2、骑车去上班！");
    }

    @Override
    public void working() {
        log.info("4、建立数据体系、数据入库、数据分析！");
    }

    @Override
    public void afterWork() {
        log.info("5、下班回家、吃饭、洗碗、洗澡、看电视、睡觉！");
    }
}
