package work.threadlocal;

import java.util.HashMap;

/**
 * @author: gorilla
 * @date: 2024/3/12 22:00
 */
public class ThreadLocalTest {

    // 创建一个 ThreadLocal 对象
    private static ThreadLocal<HashMap<String, Integer>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建并启动三个线程
        Thread thread1 = new Thread(new MyRunnable("Thread-1"));
        Thread thread2 = new Thread(new MyRunnable("Thread-2"));
        Thread thread3 = new Thread(new MyRunnable("Thread-3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class MyRunnable implements Runnable {
        private String name;

        MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            // 生成一个随机数，并存储到当前线程的 ThreadLocal 变量中
            int randomNumber = (int) (Math.random() * 100);
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
                put(name, randomNumber);
            }};
            threadLocal.set(hashMap);

            // 从当前线程的 ThreadLocal 变量中获取值，并打印
            System.out.println("Thread " + name + ": Random Number = " + threadLocal.get());

            // 模拟一些操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 清除当前线程的 ThreadLocal 变量
            threadLocal.remove();
        }
    }


}
