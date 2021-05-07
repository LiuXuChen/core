package com.jetco.core.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 开车上班
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-22
 */
@Slf4j
public class DriveToWork extends AbstractWork {

    @Override
    public void commute() {
        log.info("2、开车去上班！");
    }

    @Override
    public void working() {
        log.info("4、参加会议，听取汇报！");
    }

    @Override
    public void afterWork() {
        log.info("5、下班回家、吃饭、洗澡、看电视、睡觉！");
    }
}
