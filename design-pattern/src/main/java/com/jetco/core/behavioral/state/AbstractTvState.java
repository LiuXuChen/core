package com.jetco.core.behavioral.state;

/**
 * <p>
 * 抽象的电视机状态
 *
 * 状态模式：允许一个对象在其内部状态改变时改变其行为，这个对象看起来好像是改变了其类
 *
 * 适用场景：
 *
 * 1、行为随状态改变而改变的场景
 * 2、化繁为简，代码中有大量的switch...case、if代码等
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
public abstract class AbstractTvState {

    /**
     * 使用遥控器作为上下文，控制电视机状态的切换
     */
    protected RemoteControlMachine remoteControlMachine;

    public void setRemoteControlMachine(RemoteControlMachine remoteControlMachine) {
        this.remoteControlMachine = remoteControlMachine;
    }

    /**
     * 开机
     */
    abstract void powerOn();

    /**
     * 关机
     */
    abstract void powerOff();

    /**
     * 播放
     */
    abstract void play();

    /**
     * 待机
     */
    abstract void standby();

}
