package com.jetco.core.behavioral.command;

/**
 * <p>
 * 命令接口
 *
 * 命令模式；将发送者（发送命令）、接收者（执行命令）和调用命令封装成对象，客户端调用的时候可以选择不同的对象，
 * 从而实现发送者和接收者的完全解耦
 *
 * 优点：可扩展性好
 * 缺点：需要为不同的命令制定单独的命令类
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-21
 */
public interface Command {

    /**
     * 执行命令
     */
    void execute();
}
