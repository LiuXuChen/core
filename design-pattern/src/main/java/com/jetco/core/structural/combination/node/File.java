package com.jetco.core.structural.combination.node;

/**
 * <p>
 * 文件
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class File extends Node {

    String content;

    public File(String content) {
        this.content = content;
    }

    @Override
    void print() {
        System.out.println(this.content);
    }
}
