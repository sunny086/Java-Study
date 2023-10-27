package gorilla.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @author BigStar
 */
@Component
@Aspect
@Slf4j
public class AopTestAspect {

    /**
     * aop切点
     * 拦截被指定注解修饰的方法
     */
    @Pointcut("@annotation(gorilla.redis.cache.AopTest)")
    public void aopTest() {
    }

    /**
     * 缓存操作
     *
     * @param pjp
     * @return
     */
    @Around("aopTest()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-----------------------");
        System.out.println("环绕通知: 进入方法");
        Object o = null;
        try {
            o = pjp.proceed();
            System.out.println(o);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("环绕通知: 退出方法");
        }
        return o;
    }

    @Before("aopTest()")
    public void before(JoinPoint jp) {
        System.out.println("before");
    }

    @After("aopTest()")
    public void after(JoinPoint jp) {
        System.out.println("after");
    }

}
