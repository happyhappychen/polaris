package com.colin.polaris.thread.getmultitaskresult;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description:
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class Result {

    private String name;

    private int value;

    public String getName() {
        return name;
    }

    public Result setName(String name) {
        this.name = name;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Result setValue(int value) {
        this.value = value;
        return this;
    }
}
