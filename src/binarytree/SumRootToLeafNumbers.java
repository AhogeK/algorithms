package binarytree;

import common.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 *
 * @author AhogeK
 * @since 2025-09-18 20:20:12
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int curSum) {
        if (node == null) return 0;
        curSum = curSum * 10 + node.val;
        if (node.left == null && node.right == null) return curSum;
        return dfs(node.left, curSum) + dfs(node.right, curSum);
    }
}
