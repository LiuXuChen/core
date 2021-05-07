package com.jetco.core.behavioral.responsibilitychain.msg;

/**
 * <p>
 * 敏感词过滤处理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("996", "955");
        msg.setMsg(r);
        return false;
    }
}
