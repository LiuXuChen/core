package com.jetco.core.structural.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * JDK动态代理
 * JDK动态代理模式：
 * 通过反射技术来创建类的加载器并且创建类的实例，根据类执行方法并在方法执行前后进行前置和后置通知等处理
 *
 * JDK代理是不需要引入第三方的库，只要有JDK环境就可以进行代理，它有几个要求
 *
 * 1、实现InvocationHandler
 * 2、使用Proxy.newProxyInstance产生代理对象
 * 3、被代理的对象必须要实现接口
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-18
 */
@Slf4j
public class JdkProxy implements InvocationHandler {

    /**
     * 需要代理的目标对象
     */
    private Object target;

    /**
     * 将目标对象传入进行代理
     * @param target 需要代理的目标对象
     * @return 代理对象
     */
    public Object newProxy(Object target) {
        this.target = target;
        // 返回代理对象   反射：通过二进制字节码分析类的属性和方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 重写invoke方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理方法执行前的通知操作
        this.beforeBuyTicket();
        // 调用invoke方法，obj存储该方法的返回值
        Object obj = method.invoke(target, args);
        // 代理方法执行后的通知操作
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
