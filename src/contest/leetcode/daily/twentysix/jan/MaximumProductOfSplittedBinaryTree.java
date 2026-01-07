package contest.leetcode.daily.twentysix.jan;

import common.TreeNode;

/**
 * 1339. 分裂二叉树的最大乘积
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-07 16:19:13
 */
public class MaximumProductOfSplittedBinaryTree {
    private long total = 0;
    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        total = calculateSum(root);
        findMaxProduct(root);
        return (int) (maxProduct % 1_000_000_007);
    }

    private long findMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long leftSum = findMaxProduct(node.left);
        long rightSum = findMaxProduct(node.right);
        long currentSum = node.val + leftSum + rightSum;

        long product = currentSum * (total - currentSum);
        maxProduct = Math.max(maxProduct, product);

        return currentSum;
    }

    private long calculateSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }
}
