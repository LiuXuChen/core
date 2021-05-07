package com.jetco.core.structural.combination.node;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 目录节点
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class Directory extends Node {

    List<Node> nodes = new ArrayList<>();

    String name;

    public Directory(String name) {
        this.name = name;
    }

    public Directory addNode(Node node) {
        nodes.add(node);
        return this;
    }

    @Override
    void print() {
        System.out.println(this.name);
    }
}
