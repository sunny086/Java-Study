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
public abstract class TreeNodeV2 {
    private int id;

    private int parentId;

    private Double index;

    List<TreeNodeV2> children;

    public int getParentId() {
        return parentId;
    }

    public List<TreeNodeV2> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeV2> children) {
        this.children = children;
    }

    public TreeNodeV2(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }
}
