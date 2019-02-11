package com.colin.polaris.aop.jdkproxy;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description: 被代理类，目标类service, 在AService的add和update方法的前后实现拦截，加入自定义切面逻辑advise
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class AService implements Service {

    public void add() {
        System.out.println("AService add >>>>>>");

    }

    public void update() {
        System.out.println("AService update >>>>>>");
    }
}
