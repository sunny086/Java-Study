package work.proxy.jdk_proxy;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}
