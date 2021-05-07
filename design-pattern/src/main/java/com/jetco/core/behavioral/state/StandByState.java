package com.jetco.core.behavioral.state;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 待机状态
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
@Slf4j
public class StandByState extends AbstractTvState {

    @Override
    void powerOn() {

    }

    @Override
    void powerOff() {
        log.info("关机中。。。。。。");
        // 使用遥控器设置电视机状态为：关机状态
        super.remoteControlMachine.setCurrentState(RemoteControlMachine.POWER_OFF_STATE);
        // 执行关机的行为
        super.remoteControlMachine.powerOff();
    }

    @Override
    void play() {
        log.info("播放中。。。。。。");
        // 使用遥控器设置电视机状态为：播放状态
        super.remoteControlMachine.setCurrentState(RemoteControlMachine.PlAY_STATE);
        // 执行播放的行为
        super.remoteControlMachine.play();
    }

    @Override
    void standby() {

    }
}
