package com.colin.polaris.jvm;

/**
 * Created by Colin Chen on 2019/2/3.
 *
 * Description: 动态分派
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class DynamicDispatch {

    static abstract class Human {
        abstract void say ();
    }

    static class Man extends Human {

        @Override
        void say() {
            System.out.println("hello, man");
        }
    }

    static class Woman extends Human {

        @Override
        void say() {
            System.out.println("hello, woman");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.say();
        woman.say();
    }

}
