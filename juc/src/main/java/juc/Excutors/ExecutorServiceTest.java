package juc.Excutors;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/18 12:22
 */
public class ExecutorServiceTest {

    /**
     * 通过 Executors 工具类来创建一个 ExecutorService，然后向里面提交 Callable 任务，然后通过 Future 来获取执行结果
     */
    @Test
    public void executorTest01() throws Exception {
        // 创建一个包含5个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 创建一个Callable任务
        Callable<String> task = new Callable<String>() {
            public String call() {
                return "Hello from " + Thread.currentThread().getName();
            }
        };
        // 提交任务到ExecutorService执行，并获取Future对象
        Future[] futures = new Future[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(task);
        }
        // 通过Future对象获取任务的结果
        for (int i = 0; i < 10; i++) {
            System.out.println(futures[i].get());
        }
        // 关闭ExecutorService，不再接受新的任务，等待所有已提交的任务完成
        executorService.shutdown();
    }

    /**
     * 使用 Runnable 的方式要比 Callable 的方式简单一些，但是 Callable 的方式可以获取执行结果，这是 Runnable 做不到的
     */
    @Test
    public void executorTest02() throws Exception {
        // 创建一个包含5个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 创建一个Runnable任务
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };
        // 提交任务到ExecutorService执行
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
        // 关闭ExecutorService，不再接受新的任务，等待所有已提交的任务完成
        executorService.shutdown();
    }
}
