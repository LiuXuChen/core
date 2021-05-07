package com.jetco.core.behavioral.state;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  关机状态
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
@Slf4j
public class PowerOffState extends AbstractTvState {

    @Override
    void powerOn() {
        log.info("开机中。。。。。。");
        // 开机后状态默认为：待机状态
        super.remoteControlMachine.setCurrentState(RemoteControlMachine.STANDBY_STATE);
        // 执行待机的命令
        super.remoteControlMachine.standby();
    }

    @Override
    void powerOff() {

    }

    @Override
    void play() {

    }

    @Override
    void standby() {

    }
}
