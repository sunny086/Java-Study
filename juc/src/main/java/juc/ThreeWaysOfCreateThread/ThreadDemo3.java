package juc.ThreeWaysOfCreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现 Callable 接口，重写 call 方法，这种方式可以通过 FutureTask 获取任务执行的返回值
 *
 * @author: gorilla
 * @date: 2023/8/11 15:07
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Callable call = new MyCallable();
        FutureTask<String> task = new FutureTask<>(call);
        Thread t = new Thread(task);
        t.start();
        try {
            // 获取call方法返回的结果（正常/异常结果）
            String s = task.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<String> {
    //重写线程任务类方法
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "->" + "Hello World";
    }
}

