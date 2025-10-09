package binarytree;

import common.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 *
 * @author AhogeK
 * @since 2025-10-10 05:33:05
 */
public class MaximumSumBSTInBinaryTree {
    private int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // return [isBST, sum, min, max]
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[0] == 1 && right[0] == 1 && left[3] < node.val && node.val < right[2]) {
            int sum = left[1] + right[1] + node.val;
            ans = Math.max(ans, sum);
            int min = node.left != null ? left[2] : node.val;
            int max = node.right != null ? right[3] : node.val;
            return new int[]{1, sum, min, max};
        }
        return new int[]{0, 0, 0, 0};
    }
}
