package com.colin.polaris.thread.getmultitaskresult;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Colin Chen on 2019/2/11.
 *
 * Description:
 *
 * @author Colin Chen
 * @author chenmingkang@meituan.com
 * @version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = (ExecutorService) Executors.newCachedThreadPool();

        List<Task> taskList = new ArrayList<Task>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task(String.valueOf(i));
            taskList.add(task);
        }

        List<Future<Result>> resultList = null;
        try {
            resultList = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        System.out.println("Main: Printing the results");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.println(JSON.toJSONString(result));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
