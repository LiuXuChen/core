package com.jetco.core.behavioral.responsibilitychain.msg;

/**
 * <p>
 * 笑脸过滤处理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace(":)", "^V^");
        msg.setMsg(r);
        return true;
    }
}
