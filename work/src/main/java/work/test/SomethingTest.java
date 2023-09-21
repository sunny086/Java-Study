package work.test;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/9/20 16:55
 */
public class SomethingTest {

    /**
     * 基础数据类型 非引用 赋值逻辑
     * 乍一看还以为输出一样呢 hhh
     */
    @Test
    public void test01(){
        int a = 1;
        int b = a;
        a = 2;
        System.out.println(a);
        System.out.println(b);
    }


}
