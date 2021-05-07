package com.jetco.core.behavioral.state;

/**
 * <p>
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
public class RemoteControlMachine {

    /**
     * 待机状态
     */
    public static final AbstractTvState STANDBY_STATE = new StandByState();

    /**
     * 关机状态
     */
    public static final AbstractTvState POWER_OFF_STATE = new PowerOffState();

    /**
     * 播放状态
     */
    public static final AbstractTvState PlAY_STATE = new PlayState();

    /**
     * 标识当前状态
     */
    private AbstractTvState currentState;

    /**
     * 获取当前状态
     * @return
     */
    public AbstractTvState getCurrentState() {
        return currentState;
    }

    /**
     * 设置当前状态，遥控器负责电视机的具体状态切换
     * @param currentState
     */
    public void setCurrentState(AbstractTvState currentState) {
        this.currentState = currentState;
        this.currentState.setRemoteControlMachine(this);
    }

    /**
     * 委托给state统一去处理
     */
    public void powerOn() {
        this.currentState.powerOn();
    }

    public void powerOff() {
        this.currentState.powerOff();
    }

    public void standby() {
        this.currentState.standby();
    }

    public void play() {
        this.currentState.play();
    }
}
