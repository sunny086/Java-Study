package work.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/28 12:27
 */
public class LocalDateTimeTest {

    @Test
    public void test01() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //格式化 yyyy-MM-dd HH:mm:ss
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
    }
}
