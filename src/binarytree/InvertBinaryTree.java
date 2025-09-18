package binarytree;

import common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author AhogeK
 * @since 2025-09-18 13:34:57
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
