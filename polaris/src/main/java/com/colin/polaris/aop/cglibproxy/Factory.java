package com.colin.polaris.aop.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description:工厂类，生成增强过的目标类
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class Factory {

    public static Base getInstance (CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类CglibProxy,最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        //此刻，base不再是单纯的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        return base;
    }

}
