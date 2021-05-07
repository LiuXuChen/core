package com.jetco.core.behavioral.command;

/**
 * <p>
 * 开机命令
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
public class OpenTvCommand implements Command {

    private final Tv tv;

    public OpenTvCommand(Tv tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        this.tv.open();
    }
}
