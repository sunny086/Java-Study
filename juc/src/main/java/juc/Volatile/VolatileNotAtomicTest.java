package juc.Volatile;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * inc++不是一个原子性操作，由读取、加、赋值 3 步组成，所以结果并不能达到 10000
 *
 * @author: gorilla
 * @date: 2023/9/8 1:13
 */
public class VolatileNotAtomicTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    /**
     * 使用 CountDownLatch 等待所有线程完成
     */
    public static void main(String[] args) {
        final VolatileNotAtomicTest test = new VolatileNotAtomicTest();
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
            System.out.println("inc output:" + test.inc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 控制台一直阻塞，什么也不输出，卡死
     * debug却可以执行完毕
     * Idea工具的原因，IntelliJ Idea执行用户的代码使用的是反射的方式，与此同时会创建一个Monitor Ctrl-Break的线程用于监控的目的。
     * 所以主线程main+监控线层，最后会剩余两个线程。
     * 相同的代码，用java命令执行就没有问题。
     * 所以将Thread.activeCount的判断值改为Thread.activeCount > 2即可。
     */
    @Test
    public void test() {
        final VolatileNotAtomicTest test = new VolatileNotAtomicTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }
        System.out.println(Thread.activeCount());
        while (Thread.activeCount() > 2)
            Thread.yield();
        System.out.println("inc output:" + test.inc);
    }
}
