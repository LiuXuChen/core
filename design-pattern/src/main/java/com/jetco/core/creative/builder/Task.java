package com.jetco.core.creative.builder;

import com.jetco.core.basic.exception.exception.ParameterException;

/**
 * <p>
 *
 * 任务:利用建造者模式来来设置类中的多个参数，可实现链式编程
 *
 * 建造者模式：将一个复杂的对象的构建与它的表示相分离，使得同样的构建过程可以创建出不同的表示
 *
 * 优势：
 * 1⃣️ 封装性
 * 2⃣️ 建造者独立，易于拓展
 * 3⃣️ 便于控制细节风险
 *
 * 使用场景：
 * 1⃣️ 产品类非常复杂，不同的调度产生不同的结果时
 * 2⃣️ 相同的组件或配件都可以装配到一个对象，但是产生的结果又不相同
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-28
 */
public final class Task {

    private Long id;

    private String name;

    private Long parentId;

    private boolean status;

    private String remark;

    public Task(){}

    private Task(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.parentId = builder.parentId;
        this.status = builder.status;
        this.remark = builder.remark;
    }

    public static class Builder {
        private Long id;

        private String name;

        private Long parentId;

        private boolean status;

        private String remark;

        public Builder(Long id, String name) {
            if (id == null || name == null) {
                throw new ParameterException("id and name can not be null");
            }
            this.id = id;
            this.name = name;
        }

        public Builder parentId(Long parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder status(boolean status) {
            this.status = status;
            return this;
        }

        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
