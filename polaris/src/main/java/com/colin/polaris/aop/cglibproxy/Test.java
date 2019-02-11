package com.colin.polaris.aop.cglibproxy;

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
        CglibProxy proxy = new CglibProxy();
        Base base = Factory.getInstance(proxy);
        base.add();
    }
}
