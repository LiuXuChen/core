package com.jetco.core.behavioral.responsibilitychain.msg;

/**
 * <p>
 * url过滤处理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("jetco.com", "http://www.jetco.con");
        msg.setMsg(r);
        return true;
    }
}
