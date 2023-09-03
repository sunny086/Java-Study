package juc.ThreadPriority;

import org.junit.Test;

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
}
