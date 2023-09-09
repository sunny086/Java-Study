package work.map;

import java.util.HashMap;

/**
 * hashmap的容量计算
 *
 * @author: gorilla
 * @date: 2023/9/8 11:29
 */
public class InitHashMapWithSizeTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for (int i = 0; i < 12; i++) {
            hashMap.put(i, i);
        }
        hashMap.put(12, 12);
        System.out.println(hashMap.size());
        int capacity = capacity(hashMap);
        System.out.println(capacity);
    }

    public static int capacity(HashMap<?, ?> map) {
        try {
            java.lang.reflect.Field tableField = HashMap.class.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] table = (Object[]) tableField.get(map);
            return table == null ? 0 : table.length;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
