package work.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/23 17:45
 */
public class TimeTest {

    @Test
    public void test01() {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void test02() {
        //五百年后
        //262800000 min
        //15768000000 second
        //15768000000000 nano
        Date date = new Date();
        date.setTime(date.getTime() + 15768000000000L);
        System.out.println(date);
    }

    @Test
    public void test03() {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 创建一个表示500年的Period对象
        Period period = Period.ofYears(500);

        // 增加500年
        LocalDate futureDate = currentDate.plus(period);

        System.out.println("当前日期: " + currentDate);
        System.out.println("五百年后的日期: " + futureDate);

    }

    @Test
    public void test04() {
        // 获取当前日期
        Date currentDate = new Date();
        // 使用 Calendar 增加五百年
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, 500);
        // 将 Calendar 对象转换回 Date 对象
        Date futureDate = calendar.getTime();
        System.out.println("当前日期: " + currentDate);
        System.out.println("五百年后的日期: " + futureDate);
    }




}
