package com.colin.polaris.thread;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description:
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class Case {

    //通过volatile修饰的变量可以保证线程之间的可见性，但不能指令的原子执行，因此多线程并发执行下，无法做到线程安全
    public volatile int n;

    public void add() {
        n++;
    }
}
