package com.colin.polaris.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description:
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class ReentrantLockTest extends Thread {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    public ReentrantLockTest (String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                System.out.println(this.getName() + " " + i);
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockTest test1 = new ReentrantLockTest("thread1");
        ReentrantLockTest test2 = new ReentrantLockTest("thread2");

        test1.start();
        test2.start();
        test1.join();
        test2.join();
        //结果应该是 10000000 * 2
        System.out.println(i);

    }

}
