package binarytree;

import common.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * @author AhogeK
 * @since 2025-10-04 20:34:36
 */
public class MinimumDistanceBetweenBSTNodes {
    private int ans = Integer.MAX_VALUE;
    private Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (prev != null) ans = Math.min(ans, node.val - prev);
        prev = node.val;
        inorder(node.right);
    }
}
