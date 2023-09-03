package juc.ThreadGroup;

import org.junit.Test;

/**
 * 线程组统一异常处理
 *
 * @author: gorilla
 * @date: 2023/9/3 22:59
 */
public class ThreadGroupExceptionTest {

    @Test
    public void ThreadGroupExceptionTest01() {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };
        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });
        thread1.start();
    }

}
