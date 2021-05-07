package com.jetco.core.behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 接受者（执行命令）
 *
 * 电视的具体动作
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
@Slf4j
public class Tv {

    public void open() {
        log.info("打开电视机！");
    }

    public void close() {
        log.info("关闭电视机！");
    }

    public void change() {
        log.info("切换电视频道！");
    }
}
