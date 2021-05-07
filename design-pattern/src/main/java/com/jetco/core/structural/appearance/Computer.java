package com.jetco.core.structural.appearance;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 电脑 门面类
 * 外观模式：
 * 为子系统中的一组接口提供了一个统一的访问接口，这个接口使得子系统更容易被访问或者使用。
 * 隐藏了子系统的复杂性，使得复杂的子系统与客户端分离解耦。
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-14
 */
@Slf4j
public class Computer {

    private final Cpu cpu;

    private final Disk disk;

    private final Memory memory;

    public Computer() {
        this.cpu = new Cpu();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    public void start() {
        log.info("电脑正在启动中。。。。。。");
        this.cpu.start();
        this.disk.start();
        this.memory.start();
        log.info("电脑启动完成。。。。。。");
    }

    public void shutdown() {
        log.info("电脑正在关闭中。。。。。。");
        this.cpu.shutdown();
        this.disk.shutdown();
        this.memory.shutdown();
        log.info("电脑关闭完成。。。。。。");
    }

}
