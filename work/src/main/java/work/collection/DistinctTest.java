package work.collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/17 10:01
 */
public class DistinctTest {

    /**
     * 1. 通过HashSet去重
     */
    @Test
    public void distinctTest1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2);
        HashSet<Integer> set = new HashSet<>(list);
        List<Integer> newList = new ArrayList<>(set);
        System.out.println(newList);
    }


    /**
     * 2. 通过stream去重
     */
    @Test
    public void distinctTest2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2);
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }
    /**
     * 3. 通过TreeSet去重
     */
    @Test
    public void distinctTest3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2);
        TreeSet<Integer> set = new TreeSet<>(list);
        List<Integer> newList = new ArrayList<>(set);
        System.out.println(newList);
    }

    /**
     * 默认情况下，Java 对象的 equals 方法是比较对象的内存地址，而不是对象的属性值。
     * 要正确去重 Person 对象，需要重写 equals 和 hashCode 方法，使其比较对象的属性值
     */
    @Test
    public void distinctObjectTest1() {
        class Person {
            String name;
            Integer age;

            public Person(String name, Integer age) {
                this.name = name;
                this.age = age;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Person person = (Person) o;
                return Objects.equals(name, person.name) && Objects.equals(age, person.age);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }
        }
        List<Person> list = Arrays.asList(new Person("张三", 20), new Person("李四", 21), new Person("王五", 22), new Person("张三", 20));
        List<Person> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }


}
