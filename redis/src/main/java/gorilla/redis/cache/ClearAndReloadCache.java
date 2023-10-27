package gorilla.redis.cache;

import java.lang.annotation.*;

/**
 *延时双删
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface ClearAndReloadCache {
    String name() default "";
}
