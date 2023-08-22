package work.tree;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: xjs
 * @date: 2023/7/21 11:32
 */
@Data
public abstract class TreeNode {
    private String id;

    private String parentId;

    private Double index;

    List<TreeNode> children;

    public String getParentId() {
        return parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
