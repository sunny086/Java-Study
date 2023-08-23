package work.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/23 10:54
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }
}
