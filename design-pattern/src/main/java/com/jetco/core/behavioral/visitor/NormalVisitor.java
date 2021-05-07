package com.jetco.core.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <p>
 * 具体访问者-普通用户
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
@Slf4j
public class NormalVisitor implements Visitor {

    /**
     * 定义该用户具备的权限集合
     */
    private final List<String> lookPerms;

    public NormalVisitor(List<String> lookPerms) {
        this.lookPerms = lookPerms;
    }

    @Override
    public void visit(DirectoryElement directoryElement) {
        if(directoryElement.getLookPerms().contains(this.lookPerms.toString())) {
            log.info("当前普通用户具备权限：{} 要访问的文件夹名：{} 允许访问！", this.lookPerms.toString(), directoryElement.getName());
        } else {
            log.info("当前普通用户具备权限：{} 要访问的文件夹名：{} 权限不足，禁止访问！", this.lookPerms.toString(), directoryElement.getName());
        }
    }

    @Override
    public void visit(FileElement fileElement) {
        if(fileElement.getLookPerms().contains(this.lookPerms.toString())) {
            log.info("当前普通用户具备权限：{} 要访问的文件夹名：{} 允许访问！", this.lookPerms.toString(), fileElement.getName());
        } else {
            log.info("当前普通用户具备权限：{} 要访问的文件夹名：{} 权限不足，禁止访问！", this.lookPerms.toString(), fileElement.getName());
        }
    }
}
