package juc.ThreadStatus;

import org.junit.Test;

/**
 * 处于 RUNNABLE 状态的线程正在 Java 虚拟机中执行，但它可能正在等待来自操作系统的其他资源，比如处理器。
 * new Thread(() -> {}).start(); 之后，线程就处于 RUNNABLE 状态了。
 * 但是，处于 RUNNABLE 状态的线程也可能在等待操作系统的资源，比如处理器。
 * 比如，处于 RUNNABLE 状态的线程可能正在等待 CPU 时间片，这种情况下，线程处于就绪状态。
 * 处于就绪状态的线程正在等待 Java 虚拟机中的线程调度器（Thread Scheduler）来分配处理器时间片。
 * 一旦线程调度器把时间片分配给了某个线程，该线程就会从就绪状态变成运行状态，开始执行 run() 方法。
 * 处于 RUNNABLE 状态的线程也可能在等待操作系统的其他资源，比如网络 IO、磁盘 IO 等。
 * 这种情况下，线程处于阻塞状态。
 * 处于阻塞状态的线程正在等待操作系统的资源，一旦得到了资源，就会从阻塞状态变成就绪状态。
 * 处于 RUNNABLE 状态的线程也可能在等待其他线程释放锁，这种情况下，线程处于等待状态。
 * 处于等待状态的线程正在等待其他线程调用 notify() 或 notifyAll() 方法，或者等待超时。
 * 一旦其他线程调用了 notify() 或 notifyAll() 方法，或者等待超时，就会从等待状态变成就绪状态。
 *
 * @author: gorilla
 * @date: 2023/8/29 11:51
 */
public class StatusTest {

    /**
     * 处于 NEW 状态的线程此时尚未启动。这里的尚未启动指的是还没调用 Thread 实例的start()方法。
     */
    @Test
    public void newTest() {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState());
    }

    /**
     * new Thread(() -> {}).start() 707行 threadStatus 初始时为 0，然后调用 start() 方法，会调用 start0() 方法，
     * start0() 方法会调用 native start() 方法，native start() 方法会调用 pthread_create() 方法，
     * pthread_create() 方法会创建一个新的线程，这个新的线程就是我们的子线程。
     * 创建完子线程之后，会调用 pthread_create() 方法的返回值，也就是子线程的 ID，然后调用 pthread_join() 方法，
     * pthread_join() 方法会等待子线程执行完毕，然后返回。
     * 也就是说，new Thread(() -> {}).start() 会创建一个子线程，然后等待子线程执行完毕，然后返回。
     */
    @Test
    public void statusTest01() {
        Thread thread = new Thread(() -> {
        });
        // thread.getState() 会把threadStatus做位与运算进行状态判断
        System.out.println(thread.getState());// threadStatus 为 0
        thread.start();
        System.out.println(thread.getState()); //threadStatus 为 5
        thread.start(); //逻辑中有判断 只能start一次 有共享变量做标记 会报错
        System.out.println(thread.getState());
    }

}
