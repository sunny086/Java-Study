package juc.Volatile;

/**
 * 由于 flag 没有使用 volatile 修饰，所以线程 1 无法感知到主线程对 flag 的修改，所以线程 1 会一直循环下去。
 *
 * @author: gorilla
 * @date: 2023/9/7 13:37
 */
public class VariateNotVisibilityTest {

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                // do something
                System.out.println("flag is true");
            }
            System.out.println("flag is false");
        }).start();
        Thread.sleep(2000);
        new Thread(() -> prepareDate()).start();
    }

    public static void prepareDate() {
        System.out.println("prepare data");
        flag = true;
        System.out.println("prepare data end");
    }


}
