package work.tree;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: xjs
 * @date: 2023/7/21 11:17
 */
public class TreeUtils {

    public static int findDepth(TreeNode node, List<TreeNode> nodeList) {
        if (node == null) {
            return 0;
        }
        int depth = 1;
        for (TreeNode child : getChildren(node.getId(), nodeList)) {
            depth = Math.max(depth, 1 + findDepth(child, nodeList));
        }
        return depth;
    }

    public static List<TreeNode> getChildren(String id, List<TreeNode> nodeList) {
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node : nodeList) {
            if (node.getParentId().equals(id)) {
                children.add(node);
            }
        }
        return children;
    }

    public static int findDepthV2(TreeNodeV2 node, List<TreeNodeV2> nodeList) {
        if (node == null) {
            return 0;
        }
        int depth = 1;
        for (TreeNodeV2 child : getChildrenV2(node.getId(), nodeList)) {
            depth = Math.max(depth, 1 + findDepthV2(child, nodeList));
        }
        return depth;
    }

    public static List<TreeNodeV2> getChildrenV2(int id, List<TreeNodeV2> nodeList) {
        List<TreeNodeV2> children = new ArrayList<>();
        for (TreeNodeV2 node : nodeList) {
            if (node.getParentId() == id) {
                children.add(node);
            }
        }
        return children;
    }

    /**
     * 构建树
     *
     * @param dataList
     * @param node
     */
    private static void buildTree(List<TreeNode> dataList, TreeNode node) {
        List<TreeNode> child = findChildByParentId(dataList, node.getId());
        if (!CollectionUtils.isEmpty(child)) {
            node.setChildren(child);
            for (TreeNode tree : child) {
                buildTree(dataList, tree);
            }
        }
    }

    /**
     * 查询当前节点的子节点，不包含子子
     */
    private static List<TreeNode> findChildByParentId(List<TreeNode> dataList, String parentId) {
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node : dataList) {
            if (node.getParentId() == null && parentId == null) {
                children.add(node);
                continue;
            }
            if (node.getParentId() != null && node.getParentId().equals(parentId)) {
                children.add(node);
            }
        }
        return children;
    }

    /**
     * 查询当前节点的关键链路上的所有父级节点
     */
    public static List<TreeNodeV2> findParentByChild(List<TreeNodeV2> dataList, TreeNodeV2 child) {
        int parentId = child.getParentId();
        List<TreeNodeV2> parents = new ArrayList<>();
        // 根节点的parentId为0，无需继续递归，直接返回
        if (parentId == 0) {
            return parents;
        }
        TreeNodeV2 parent = null;
        for (TreeNodeV2 node : dataList) {
            if (node.getId() == parentId) {
                parent = node;
                break;
            }
        }
        if (parent != null) {
            parents.add(parent);
            // 递归查询父级的父级
            parents.addAll(findParentByChild(dataList, parent));
        }
        return parents;
    }
}
