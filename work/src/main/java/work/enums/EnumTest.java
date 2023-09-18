package work.enums;

import org.junit.Test;

/**
 * 枚举测试
 *
 * @author: gorilla
 * @date: 2023/9/18 10:25
 */
public class EnumTest {

    @Test
    public void test01() {

        SubjectType user = SubjectType.USER;

        System.out.println(user);
        System.out.println(user.name());
        System.out.println(user.ordinal());
        //枚举还需要.name 不然拿到的只是一个对象
        System.out.println(user.equals(SubjectType.USER));
        System.out.println(user.name().equals(SubjectType.USER));
    }


}
