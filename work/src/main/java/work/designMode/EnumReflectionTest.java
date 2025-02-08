package work.designMode;

import java.lang.reflect.Constructor;

public class EnumReflectionTest {
    public static void main(String[] args) throws Exception {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;

        // 反射创建枚举单例（会抛异常！）
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonEnum instance2 = constructor.newInstance();  // 这里会报错！

        System.out.println(instance1 == instance2);
    }
}
