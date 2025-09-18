package binarytree;

import common.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 * @author AhogeK
 * @since 2025-09-18 14:39:08
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
