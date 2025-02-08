package work.proxy.jdk_proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        Hello proxy = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                new JDKProxy(hello)
        );

        proxy.sayHello();
    }

}
