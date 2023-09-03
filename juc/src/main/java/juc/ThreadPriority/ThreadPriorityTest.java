package juc.ThreadPriority;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Java中线程优先级可以指定，范围是1~10。但是并不是所有的操作系统都支持10级优先级的划分（比如有些操作系统只支持3级划分：低，中，高）
 * Java只是给操作系统一个优先级的参考值，线程最终在操作系统的优先级是多少还是由操作系统线程调度算法决定
 *
 * @author: gorilla
 * @date: 2023/9/3 21:08
 */
public class ThreadPriorityTest {

    @Test
    public void ThreadPriorityTest01() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("t1");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("t2");
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("t3");
            }
        });
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

    /*
     * 从输出可以看出优先级并不能完全决定线程执行的先后顺序，只是大概率上优先级高的线程会先执行
     * Java提供一个线程调度器来监视和控制处于RUNNABLE状态的线程
     * 线程的调度策略采用抢占式，优先级高的线程比优先级低的线程会有更大的几率优先执行
     * 在优先级相同的情况下，按照“先到先得”的原则
     * 每个Java程序都有一个默认的主线程，就是通过JVM启动的第一个线程main线程
     * 还有一种线程称为守护线程（Daemon），守护线程默认的优先级比较低
     */
    @Test
    public void ThreadPriorityTest02() {
        class T1 extends Thread {
            @Override
            public void run() {
                super.run();
                System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority()));
            }
        }
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }
}
