package work.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * main方式启动的时候，@PostConstruct不会执行
 * 但是springboot启动的时候，@PostConstruct会执行
 *
 * @author: gorilla
 * @date: 2023/9/9 11:22
 */
@Component
public class PostConstructTest {

    List<Integer> list;

    @PostConstruct
    public void init() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        this.list = temp;
    }

    public static void main(String[] args) {
        System.out.println(new PostConstructTest().list);
    }


}
