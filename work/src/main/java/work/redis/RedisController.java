package work.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/22 18:11
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;


    @PostMapping(value = "/add")
    public boolean add() {
        Object test01 = redisTemplate.opsForValue().get("test01");
        System.out.println(test01);

        Set keys = redisTemplate.keys("*");
        System.out.println(keys);
        return true;
    }


}
