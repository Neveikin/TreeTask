package DiskWork.DiskWork.model;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private TreeNode root;
    private final TreeNode NIL;

    public RedBlackTree() {
        NIL = new TreeNode(null);
        NIL.setRed(false);
        root = NIL;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(Integer value) {
        TreeNode node = new TreeNode(value);
        node.setLeft(NIL);
        node.setRight(NIL);
        
        TreeNode parent = null;
        TreeNode current = root;

        while (current != NIL) {
            parent = current;
            if (node.getValue().compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        node.setParent(parent);
        if (parent == null) {
            root = node;
        } else if (node.getValue().compareTo(parent.getValue()) < 0) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        if (node.getParent() == null) {
            node.setRed(false);
            return;
        }

        if (node.getParent().getParent() == null) {
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(TreeNode node) {
        TreeNode uncle;
        while (node.getParent() != null && node.getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getRight()) {
                uncle = node.getParent().getParent().getLeft();
                if (uncle.isRed()) {
                    uncle.setRed(false);
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    leftRotate(node.getParent().getParent());
                }
            } else {
                uncle = node.getParent().getParent().getRight();
                if (uncle.isRed()) {
                    uncle.setRed(false);
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rightRotate(node.getParent().getParent());
                }
            }
            if (node == root) {
                break;
            }
        }
        root.setRed(false);
    }

    private void leftRotate(TreeNode x) {
        TreeNode y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != NIL) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(TreeNode x) {
        TreeNode y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != NIL) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    public TreeNode search(Integer value) {
        TreeNode current = root;
        while (current != NIL) {
            if (value.equals(current.getValue())) {
                return current;
            } else if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node != NIL) {
            inorderTraversalHelper(node.getLeft(), result);
            result.add(node.getValue());
            inorderTraversalHelper(node.getRight(), result);
        }
    }

    public List<Integer> getNodesByLevel() {
        List<Integer> result = new ArrayList<>();
        if (root == NIL) {
            return result;
        }
        
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            result.add(currentLevel.size());
            List<TreeNode> nextLevel = new ArrayList<>();
            
            for (TreeNode node : currentLevel) {
                if (node.getLeft() != NIL) {
                    nextLevel.add(node.getLeft());
                }
                if (node.getRight() != NIL) {
                    nextLevel.add(node.getRight());
                }
            }
            
            currentLevel = nextLevel;
        }
        
        return result;
    }

    public void clear() {
        root = NIL;
    }
}
