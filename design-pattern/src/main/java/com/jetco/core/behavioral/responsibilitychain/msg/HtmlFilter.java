package com.jetco.core.behavioral.responsibilitychain.msg;

/**
 * <p>
 * HTMl过滤处理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<', '[');
        r = r.replace(">", "]");
        msg.setMsg(r);
        return true;
    }
}
