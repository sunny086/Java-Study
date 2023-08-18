package work.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取文件
 *
 * @author: gorilla
 * @date: 2023/8/18 14:46
 */
public class ReadFileTest {


    static String filePath = "work/src/main/java/work/io/model_json.txt";

    /**
     * main方法可以直接使用相对路径读取文件
     */
    public static void main(String[] args) throws Exception {
        test01();
    }

    /**
     * 使用 FileReader 和 BufferedReader： 这是最基本的文件读取方法，适用于文本文件
     */
    private static void test01() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用绝对路径读取文件 @Test使用相对路径报错
     */
    @Test
    public void test02() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\JetBrains\\Code\\Java\\Java-Study\\work\\src\\main\\java\\work\\io\\model_json.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
