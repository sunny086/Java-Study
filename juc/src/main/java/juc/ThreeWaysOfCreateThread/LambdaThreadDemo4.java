package juc.ThreeWaysOfCreateThread;

/**
 * java8可以使用lambda精简代码
 * Lambda can be replaced with method reference
 * （）->      可以进一步改成       ThreadDemo4::task
 *
 * @author: gorilla
 * @date: 2023/8/12 16:15
 */
public class LambdaThreadDemo4 {
    public static void main(String[] args) {
        Runnable t = LambdaThreadDemo4::task;
        new Thread(t, "task").start();
    }

    public static void task() {
        System.out.println("task");
    }
}

