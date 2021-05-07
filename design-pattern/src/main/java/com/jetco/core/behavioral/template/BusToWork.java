package com.jetco.core.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 坐公交上班
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-22
 */
@Slf4j
public class BusToWork extends AbstractWork {

    @Override
    public void commute() {
        log.info("2、坐公交去上班！");
    }

    @Override
    public void working() {
        log.info("4、听取领导安排任务、分析需求、敲代码、测试！");
    }
}
