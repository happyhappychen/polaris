package com.colin.polaris.aop.cglibproxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description: 代理类，用于在pointcut处添加advise
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class CglibProxy implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //MethodBeforeAdviceInterceptor
        System.out.println("before >>>>>>");
        methodProxy.invokeSuper(o, objects);
        //MethodAfterAdviceInterceptor
        System.out.println("after >>>>>>");
        return null;
    }
}
