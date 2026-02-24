package contest.leetcode.daily.twentysix.february;

import common.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-24 09:53:14
 */
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum << 1 | node.val;
        if (node.left == null && node.right == null) return currentSum;
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
