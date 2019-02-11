package com.colin.polaris.aop.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description:
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Service aService = new AService();
        MyInvocationHandler handler = new MyInvocationHandler(aService);
        //Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例
        Service aServiceProxy = (Service) Proxy
                .newProxyInstance(aService.getClass().getClassLoader(), aService.getClass().getInterfaces(), handler);
        //由动态生成的代理对象aServiceProxy来代理执行程序，其中aServiceProxy服务service接口
        aServiceProxy.add();
        System.out.println();
        aServiceProxy.update();
    }
}
