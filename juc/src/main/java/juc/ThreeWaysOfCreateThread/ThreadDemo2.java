package juc.ThreeWaysOfCreateThread;

import lombok.extern.log4j.Log4j2;

/**
 * 创建一个类实现 Runnable 接口，并重写 run 方法，将该类的实例传入 Thread 类的构造方法中，调用 start 方法启动线程
 *
 * 通过继承 Thread 的方法和实现 Runnable 接口的方式创建多线程，哪个好？
 * 实现 Runable 接口好，原因有两个：
 * ①、避免了 Java 单继承的局限性，Java 不支持多重继承，因此如果我们的类已经继承了另一个类，就不能再继承 Thread 类了。
 * ②、适合多个相同的程序代码去处理同一资源的情况，把线程、代码和数据有效的分离，更符合面向对象的设计思想。Callable 接口与 Runnable 非常相似，但可以返回一个结果
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
