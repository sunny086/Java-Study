package work.jni;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: gorilla
 * @date: 2023/8/29 12:27
 */
public class Hello {
    static {
        String prePath = System.getProperty("user.dir");
        //需要dll后缀
        String sufPath = "/work/src/main/java/work/jni/Hello.dll";
        Path path = Paths.get(prePath, sufPath);
        System.load(path.toString());
    }

    private native void sayHello();

    public static void main(String[] args) {
        Hello helloWorld = new Hello();
        helloWorld.sayHello(); // 调用 native 方法
    }
}

/**
 * D:\JetBrains\Code\Java\Java-Study\work\src\main\java\work\jni javac -h . Hello.java
 * D:\JetBrains\Code\Java\Java-Study\work\src\main\java  javah -classpath .  -jni work.jni.Hello
 * <p>
 * -d 指定生成的文件的输出目录
 * D:\JetBrains\Code\Java\Java-Study\work\src\main\java  javah -classpath . -d .\work\  -jni work.jni.Hello
 * <p>
 * windows生成的是dll linux生成的so
 * <p>
 * gcc -shared -o Hello.dll -I"D:\jdk1.8.0_261\include" -I"D:\jdk1.8.0_261\include\win32" Hello.c
 * <p>
 * gcc -shared -o libhello.so -I$JAVA_HOME/include -I$JAVA_HOME/include/linux hello.c
 * gcc -shared -o hello.dll -I"C:\path\to\jdk\include" -I"C:\path\to\jdk\include\win32" hello.c
 */


/**
 * -d 指定生成的文件的输出目录
 * D:\JetBrains\Code\Java\Java-Study\work\src\main\java  javah -classpath . -d .\work\  -jni work.jni.Hello
 */

/**
 * windows生成的是dll linux生成的so
 *
 * gcc -shared -o Hello.dll -I"D:\jdk1.8.0_261\include" -I"D:\jdk1.8.0_261\include\win32" Hello.c
 *
 * gcc -shared -o libhello.so -I$JAVA_HOME/include -I$JAVA_HOME/include/linux hello.c
 * gcc -shared -o hello.dll -I"C:\path\to\jdk\include" -I"C:\path\to\jdk\include\win32" hello.c
 */




