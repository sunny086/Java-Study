package work.jni;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/29 12:27
 */
public class Hello {
    static {
        String prePath = System.getProperty("user.dir");
        String sufPath = "/work/src/main/java/work/native_test/hello.dll";
        Path path = Paths.get(prePath, sufPath);
        System.load(path.toString());
    }

    private native void sayHello();

    public static void main(String[] args) {
        Hello helloWorld = new Hello();
        helloWorld.sayHello(); // 调用 native 方法
    }
}

