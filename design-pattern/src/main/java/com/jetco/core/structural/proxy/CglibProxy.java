package com.jetco.core.structural.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 * CGLIB动态代理购票
 *
 * CGLIB动态代理模式：
 *
 *  CGLib必须依赖于CGLib的类库，但是它需要类来实现任何接口代理的是指定的类生成一个子类，覆盖其中的方法，是一种继承
 *  但是针对接口编程的环境下推荐使用JDK的代理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-18
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

    /**
     * CGLib需要代理的目标对象
     */
    private Object target;

    /**
     * 创建CGLIB代理对象
     * @param target 代理目标对象
     * @return CGLIB代理对象
     */
    public Object createProxyObject(Object target) {
        this.target = target;
        // CGLIB  enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置代理对象的父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数，定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
        enhancer.setCallback(this);
        // 返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        this.beforeBuyTicket();
        // CGLIB反射调用真实对象的方法
        Object obj = method.invoke(target, args);
        this.afterBuyTicket();
        return obj;
    }

    private void beforeBuyTicket(){
        log.info("去火车站售票窗口排队、付钱。。。。。。");
    }

    private void afterBuyTicket(){
        log.info("从火车站进站口排队、人脸识别、安检。。。。。。");
    }
}
