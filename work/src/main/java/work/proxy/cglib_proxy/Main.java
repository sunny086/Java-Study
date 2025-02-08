package work.proxy.cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new CGLIBProxy());
        Hello proxy = (Hello) enhancer.create();

        proxy.sayHello();
    }
}
