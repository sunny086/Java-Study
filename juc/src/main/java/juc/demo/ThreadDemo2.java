package juc.demo;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/11 14:56
 */
@Log4j2(topic = "enjoy")
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable target = new MyRunnable();
        Thread t1 = new Thread(target, "1号线程");
        t1.start();
        Thread t2 = new Thread(target);//Thread-0
        t2.start();
        log.info("{}", Thread.currentThread().getName());
    }
}

@Log4j2(topic = "MyRunnable")
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.info("{}->{}", Thread.currentThread().getName(), i);
        }
    }
}
