package com.colin.polaris.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description: 1+2+......10亿，每个任务只能处理1000个数相加，超过1000个的自动分解成小任务并行处理
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class ForkJoinTask extends RecursiveTask<Long> {

    private static final long MAX = 1000000000L;

    private static final long THRESHOLD = 100000000L;

    private long start;

    private long end;

    public ForkJoinTask (long start, long end) {
        this.start = start;
        this.end = end;
    }

    private static void test() {
        System.out.println("test");
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0L; i < MAX; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    private static void testForkJoin() {
        System.out.println("testForkJoin");
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long sum = forkJoinPool.invoke(new ForkJoinTask(1, MAX));
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    @Override
    protected Long compute() {
        long sum = 0;
        //首先判断任务是否小于阈值，如果是就执行任务，否则拆分成两个子任务
        //每个子任务在调用fork的时候继续进行拆分
        if (end - start <= THRESHOLD) {
            for (long i = start; i<end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            ForkJoinTask task1 = new ForkJoinTask(start, mid);
            task1.fork();
            ForkJoinTask task2 = new ForkJoinTask(mid, end);
            task2.fork();

            return task1.join() + task2.join();
        }
    }

    public static void main(String[] args) {
        test();
        System.out.println("######");
        testForkJoin();
    }
}
