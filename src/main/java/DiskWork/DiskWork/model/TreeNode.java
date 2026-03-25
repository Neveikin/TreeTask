package DiskWork.DiskWork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TreeNode {
    private Integer value;
    private boolean isRed;
    private TreeNode left;
    private TreeNode right;
    
    @JsonIgnore
    private TreeNode parent;

    public TreeNode(Integer value) {
        this.value = value;
        this.isRed = true;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
