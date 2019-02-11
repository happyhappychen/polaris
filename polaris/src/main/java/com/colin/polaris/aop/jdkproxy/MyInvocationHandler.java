package com.colin.polaris.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description: 实现动态代理类，
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler() {
        super();
    }

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //程序执行前加入逻辑 MethodBeforeAdviceInterceptor
        System.out.println("before >>>>>>");
        //程序执行
        Object result = method.invoke(target, args);
        //程序执行后加入逻辑 MethodAfterAdviceInterceptor
        System.out.println("after >>>>>>");
        return result;
    }
}
