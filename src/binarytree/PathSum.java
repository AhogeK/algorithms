package binarytree;

import common.TreeNode;

/**
 * 112. 路径总和
 *
 * @author AhogeK
 * @since 2025-09-18 14:50:11
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        int remain = targetSum - root.val;
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }
}
