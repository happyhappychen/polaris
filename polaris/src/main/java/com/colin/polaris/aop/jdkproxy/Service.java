package com.colin.polaris.aop.jdkproxy;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description: 该类是所有被代理类的接口类，jdk实现的代理要求被代理类基于统一的接口
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public interface Service {

    public void add();

    public void update();

}
