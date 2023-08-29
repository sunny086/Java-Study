package juc.ThreadStatus;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
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

    public void statusTest01(){

    }

}
