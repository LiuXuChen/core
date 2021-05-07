package com.jetco.core.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 具体访问者-root用户
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
@Slf4j
public class RootVisitor implements Visitor {

    @Override
    public void visit(DirectoryElement directoryElement) {
        log.info("当前root用户要访问的文件夹名：{} 允许访问！", directoryElement.getName());
    }

    @Override
    public void visit(FileElement fileElement) {
        log.info("当前root用户要访问的文件夹名：{} 允许访问！", fileElement.getName());
    }
}
