package com.jetco.core.basic.bean;

import java.util.List;

/**
 * <p>
 * 树形节点抽象类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2019-10-12
 */
public abstract class AbstractTreeNode {

    private String id ;

    private String name ;

    private String type;

    private boolean checked;

    private String parentId;

    private String parentName;

    private List<? extends AbstractTreeNode> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<? extends AbstractTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<? extends AbstractTreeNode> children) {
        this.children = children;
    }
}
