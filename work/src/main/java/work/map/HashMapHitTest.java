package work.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/9/9 16:29
 */
public class HashMapHitTest {


    @Test
    public void test() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Map<Integer, Integer> innerMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                innerMap.put(j, j);
            }
            map.put(i, innerMap);
        }

        System.out.println(map.get(1).get(1));
        System.out.println(map.get(1).get(100));
        //NullPointerException
        System.out.println(map.get(100).get(100));


    }


}
