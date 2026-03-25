package DiskWork.DiskWork.dto;

public class TreeNodeDto {
    private Integer value;
    private boolean isRed;
    private TreeNodeDto left;
    private TreeNodeDto right;
    private TreeNodeDto parent;

    public TreeNodeDto() {}

    public TreeNodeDto(Integer value, boolean isRed, TreeNodeDto left, TreeNodeDto right, TreeNodeDto parent) {
        this.value = value;
        this.isRed = isRed;
        this.left = left;
        this.right = right;
        this.parent = parent;
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

    public TreeNodeDto getLeft() {
        return left;
    }

    public void setLeft(TreeNodeDto left) {
        this.left = left;
    }

    public TreeNodeDto getRight() {
        return right;
    }

    public void setRight(TreeNodeDto right) {
        this.right = right;
    }

    public TreeNodeDto getParent() {
        return parent;
    }

    public void setParent(TreeNodeDto parent) {
        this.parent = parent;
    }
}
