package work;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@SpringBootTest
class WorkApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        redisTemplate.opsForHash().put("test", "test01", "test01");
        redisTemplate.opsForValue().set("test02", "test01");
        String test01 = (String) redisTemplate.opsForValue().get("test01");
        System.out.println(test01);
        Set keys = redisTemplate.keys("*");
        System.out.println(keys);

    }

}
