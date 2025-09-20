package binarytree;

import common.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author AhogeK
 * @since 2025-09-20 12:14:51
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
