package work.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 报表的attribute中包含url，url里面包含&符号，xml解析的时候会报错，所以需要将url中的&符号转义
 * 精确匹配link-url
 *
 * @author: gorilla
 * @date: 2023/8/12 17:02
 */
public class MatchSpecifyChar {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("work/src/main/java/work/regex/link-url.xml");
        //读取文件内容
        String content = new String(Files.readAllBytes(path));
        String regex = "link-url=\"(\\$\\{.*?\\})\"";
        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(regex);
        // 创建 Matcher 对象，用于匹配正则表达式
        Matcher matcher = pattern.matcher(content);
        // 遍历匹配结果并输出
        while (matcher.find()) {
            // 获取第一个捕获组的内容
            String match = matcher.group(1);
            System.out.println("Match: " + match);
        }
    }
}
