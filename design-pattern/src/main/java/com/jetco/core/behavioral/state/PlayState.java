package com.jetco.core.behavioral.state;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 播放状态
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
@Slf4j
public class PlayState extends AbstractTvState {

    @Override
    void powerOn() {

    }

    @Override
    void powerOff() {
        log.info("关机中。。。。。。");
        // 使用遥控器设置电视机状态为：关机状态
        super.remoteControlMachine.setCurrentState(RemoteControlMachine.POWER_OFF_STATE);
        // 执行关机的命令
        super.remoteControlMachine.powerOff();
    }

    @Override
    void play() {

    }

    @Override
    void standby() {
        log.info("待机中。。。。。。");
        // 使用遥控器设置电视机状态为：待机状态
        super.remoteControlMachine.setCurrentState(RemoteControlMachine.STANDBY_STATE);
        // 执行待机的命令
        super.remoteControlMachine.standby();
    }
}
