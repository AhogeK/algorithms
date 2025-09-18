package binarytree;

import common.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author AhogeK
 * @since 2025-09-18 21:39:03
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) return (1 << leftDepth) + countNodes(root.right);
        else return (1 << rightDepth) + countNodes(root.left);
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
}
