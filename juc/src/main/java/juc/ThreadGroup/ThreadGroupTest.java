package juc.ThreadGroup;

import org.junit.Test;

/**
 * ThreadGroup管理着它下面的Thread，ThreadGroup是一个标准的向下引用的树状结构
 * 这样设计的原因是防止"上级"线程被"下级"线程引用而无法有效地被GC回收。
 *
 * @author: gorilla
 * @date: 2023/9/3 20:42
 */
public class ThreadGroupTest {

    /**
     * ThreadGroup 对Thread进行批量控制
     * 每个Thread必然存在于一个ThreadGroup中，Thread不能独立于ThreadGroup存在。执行main()方法线程的名字是main，
     * 如果在new Thread时没有显式指定，那么默认将父线程（当前执行new Thread的线程）线程组设置为自己的线程组。
     */
    @Test
    public void ThreadGroupTest01() {
        ThreadGroup threadGroup = new ThreadGroup("group1");
        Thread thread = new Thread(threadGroup, () -> {
            System.out.println("thread run");
        });
        thread.start();
        System.out.println(threadGroup.activeCount());
        System.out.println(threadGroup.activeGroupCount());
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent());
        System.out.println(threadGroup.getParent().getName());
        System.out.println(threadGroup.getParent().getParent());
    }


}
