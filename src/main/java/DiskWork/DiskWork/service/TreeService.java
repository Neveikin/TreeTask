package DiskWork.DiskWork.service;

import DiskWork.DiskWork.model.RedBlackTree;
import DiskWork.DiskWork.model.TreeNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class TreeService {
    private final RedBlackTree tree;

    public TreeService() {
        this.tree = new RedBlackTree();
    }

    public TreeNode insert(Integer value) {
        tree.insert(value);
        return tree.search(value);
    }

    public TreeNode search(Integer value) {
        return tree.search(value);
    }

    public List<Integer> getAllNodes() {
        return tree.inorderTraversal();
    }

    public void clearTree() {
        tree.clear();
    }

    public TreeNode getRoot() {
        TreeNode root = tree.getRoot();
        return (root != null && root.getValue() != null) ? root : null;
    }

    public int getTreeHeight() {
        TreeNode root = tree.getRoot();
        if (root == null || root.getValue() == null) {
            return 0;
        }
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode node) {
        if (node == null || node.getValue() == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public Map<String, Integer> getRedBlackRatio() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("red", 0);
        counts.put("black", 0);
        counts.put("total", 0);
        countNodes(tree.getRoot(), counts);
        return counts;
    }

    private void countNodes(TreeNode node, Map<String, Integer> counts) {
        if (node == null || node.getValue() == null) return;
        if (node.isRed()) {
            counts.put("red", counts.get("red") + 1);
        } else {
            counts.put("black", counts.get("black") + 1);
        }
        counts.put("total", counts.get("total") + 1);
        countNodes(node.getLeft(), counts);
        countNodes(node.getRight(), counts);
    }

    public int getNodeDepth(Integer value) {
        TreeNode node = tree.search(value);
        if (node == null) {
            return -1;
        }
        
        int depth = 0;
        TreeNode current = node;
        TreeNode root = tree.getRoot();
        
        while (current != root) {
            current = current.getParent();
            depth++;
        }
        
        return depth;
    }

    public List<Integer> getNodesByLevel() {
        return tree.getNodesByLevel();
    }
}
