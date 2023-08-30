package juc.ThreadStatus;

import org.junit.Test;

/**
 * BLOCKED 与 RUNNABLE 状态的转换
 *
 * @author: xjs
 * @date: 2023/8/31 0:30
 */
public class BlockedTest {

    /**
     * 处于 BLOCKED 状态的线程是因为在等待锁的释放。
     * 假如这里有两个线程 a 和 b，a 线程提前获得了锁并且暂未释放锁，此时 b 就处于 BLOCKED 状态
     */
    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(this::testMethod, "a");

        Thread b = new Thread(this::testMethod, "b");

        a.start();
//        Thread.sleep(1000L);
        a.join();
        b.start();

        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
