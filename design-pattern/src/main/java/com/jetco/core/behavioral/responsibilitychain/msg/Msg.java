package com.jetco.core.behavioral.responsibilitychain.msg;

/**
 * <p>
 * 消息
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class Msg {

    private String name;

    private String msg;

    public String getName() {
        return name;
    }

    public Msg setName(String name) {
        this.name = name;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Msg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
