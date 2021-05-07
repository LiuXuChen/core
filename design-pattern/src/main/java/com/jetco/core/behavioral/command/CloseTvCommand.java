package com.jetco.core.behavioral.command;

/**
 * <p>
 * 关机命令
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
public class CloseTvCommand implements Command {

    private final Tv tv;

    public CloseTvCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.close();
    }
}
