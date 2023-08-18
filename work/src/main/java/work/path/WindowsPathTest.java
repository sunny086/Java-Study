package work.path;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/18 17:12
 */
public class WindowsPathTest {

    /**
     * 获取当前项目路径
     * D:\JetBrains\Code\Java\Java-Study\work
     */
    @Test
    public void test01() {
        String path = System.getProperty("user.dir");
        System.out.println(path);
    }

    /**
     * /D:/JetBrains/Code/Java/Java-Study/work/target/classes/
     */
    @Test
    public void test02() {
        ProtectionDomain protectionDomain = WindowsPathTest.class.getProtectionDomain();
        CodeSource codeSource = protectionDomain.getCodeSource();
        String classFilePath = codeSource.getLocation().getPath();
        System.out.println("Class File Path: " + classFilePath);
    }

    /**
     * 路径字符串拼接
     */
    @Test
    public void test03() {
        Path path = Paths.get("foo/ss", "/bar/", "baz.txt");
        System.out.println(path);
    }

    /**
     * 路径字符串拼接 有弊端
     */
    @Test
    public void test04() {
        String path = "foo" + File.separator + "bar" + File.separator + "baz.txt";
        System.out.println(path);
    }


}
