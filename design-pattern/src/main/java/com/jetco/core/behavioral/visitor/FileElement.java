package com.jetco.core.behavioral.visitor;

/**
 * <p>
 * 具体访问元素-文件元素
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public class FileElement implements Element {

    /**
     * 当前元素的访问权限
     */
    private final String lookPerms;

    /**
     * 文件名
     */
    private final String name;

    public FileElement(String lookPerms, String name) {
        this.lookPerms = lookPerms;
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getLookPerms() {
        return lookPerms;
    }

    public String getName() {
        return name;
    }
}
