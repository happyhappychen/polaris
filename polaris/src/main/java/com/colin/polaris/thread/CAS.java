package com.colin.polaris.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description: CAS（compare and swap）用作原子操作
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class CAS {

    public static class MyLock {
        private AtomicBoolean locked = new AtomicBoolean(false);

        public boolean lock () {
            return locked.compareAndSet(false, true);
        }
    }

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        System.out.println("success");
    }

}
