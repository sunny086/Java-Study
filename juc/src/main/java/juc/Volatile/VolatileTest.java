package juc.Volatile;

/**
 * inc++不是一个原子性操作，由读取、加、赋值 3 步组成，所以结果并不能达到 10000。
 * volatile 保证了可见性和指令重排问题，但是不能保证原子性问题
 *
 * @author: gorilla
 * @date: 2023/9/4 17:55
 */
public class VolatileTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileTest.increase();
                }
            });
            threads[i].start();
        }

        // 使用 Thread.join() 等待所有线程完成
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println(volatileTest.inc);
    }


}
