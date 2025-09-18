package binarytree;

import common.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author AhogeK
 * @since 2025-09-18 14:22:17
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
