package com.jetco.core.behavioral.command;

/**
 * <p>
 * 更换频道命令
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
public class ChangeTvCommand implements Command {

    private final Tv tv;

    public ChangeTvCommand(Tv tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        this.tv.change();
    }
}
