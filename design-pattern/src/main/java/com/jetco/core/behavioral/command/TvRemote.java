package com.jetco.core.behavioral.command;

/**
 * <p>
 * 执行者（发起执行命令的对象）
 *
 * 遥控器
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-21
 */
public class TvRemote {

    private final Command openTvCommand;

    private final Command closeTvCommand;

    private final Command changeTvCommand;

    public TvRemote(Command openTvCommand, Command closeTvCommand, Command changeTvCommand) {
        this.openTvCommand = openTvCommand;
        this.closeTvCommand = closeTvCommand;
        this.changeTvCommand = changeTvCommand;
    }

    public void open() {
        this.openTvCommand.execute();
    }

    public void close() {
        this.closeTvCommand.execute();
    }

    public void change() {
        this.changeTvCommand.execute();
    }
}
