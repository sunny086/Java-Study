package work.tree.test;

import org.junit.Test;
import work.tree.TreeNodeV2;
import work.tree.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gorilla
 * @date: 2023/8/21 17:14
 */
public class TreeTest {
    static List<TreeNodeV2> list = new ArrayList<>();
    static {
        TreeNodeV2 node1 = new TestNode(1, 0);
        TreeNodeV2 node2 = new TestNode(2, 1);
        TreeNodeV2 node3 = new TestNode(3, 2);
        TreeNodeV2 node4 = new TestNode(4, 3);
        TreeNodeV2 node5 = new TestNode(5, 3);
        TreeNodeV2 node6 = new TestNode(6, 2);
        TreeNodeV2 node7 = new TestNode(7, 1);
        TreeNodeV2 node8 = new TestNode(8, 7);
        TreeNodeV2 node9 = new TestNode(9, 7);
        TreeNodeV2 node10 = new TestNode(10, 9);
        TreeNodeV2 node11 = new TestNode(11, 0);
        TreeNodeV2 node12 = new TestNode(12, 0);
        TreeNodeV2 node13 = new TestNode(13, 0);
        TreeNodeV2 node14 = new TestNode(14, 0);
        TreeNodeV2 node15 = new TestNode(15, 0);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);
        list.add(node8);
        list.add(node9);
        list.add(node10);
        list.add(node11);
        list.add(node12);
        list.add(node13);
        list.add(node14);
        list.add(node15);
    }


    @Test
    public void test01() {
        List<TreeNodeV2> parentByChild = TreeUtils.findParentByChild(list, new TestNode(10, 9));
        System.out.println(parentByChild);
    }


}
