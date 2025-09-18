package binarytree;

import common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 *
 * @author AhogeK
 * @since 2025-09-18 22:00:34
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);
        int currentMaxPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentMaxPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}
