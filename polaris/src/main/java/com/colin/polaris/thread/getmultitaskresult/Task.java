package com.colin.polaris.thread.getmultitaskresult;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description:
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class Task implements Callable<Result> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public Result call() throws Exception {
        System.out.printf("%s: Starting\n", this.name);
        long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
        TimeUnit.SECONDS.sleep(duration);

        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int) (Math.random() * 100);
        }

        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);

        System.out.println(this.name + ": Ends");

        return result;
    }
}
