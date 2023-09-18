package work.referenceDataType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 引用数据类型：类class 接口interface 数组
 *
 * @author: gorilla
 * @date: 2023/9/11 12:01
 */
public class referenceDataTypeTest {

    @Test
    public void mapListTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Map<Integer, List<Integer>> m = new HashMap<>();
        m.put(1, list);
        m.forEach((k, v) -> System.out.println(v));
        list.add(5);
        m.forEach((k, v) -> System.out.println(v));
    }

    @Test
    public void objectTest() {
        RData rData = new RData();
        rData.setName("大猩猩");
        System.out.println(rData);
        updateObject(rData);
        System.out.println(rData);
    }

    public  void  updateObject(RData rData){
        rData.setName("小板栗");
    }


}
