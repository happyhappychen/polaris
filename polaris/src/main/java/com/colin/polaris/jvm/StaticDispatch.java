package com.colin.polaris.jvm;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description: 静态分派
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class StaticDispatch {

    static abstract class Human {}

    static class Man extends Human {}

    static class Woman extends Human {}

    public void hello (Human guy) {
        System.out.println("hello, human");
    }

    public void hello (Man man) {
        System.out.println("hello, man");
    }


    public void hello (Woman woman) {
        System.out.println("hello, woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.hello(man);
        staticDispatch.hello(woman);
    }

}
