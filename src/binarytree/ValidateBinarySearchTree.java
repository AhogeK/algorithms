package binarytree;

import common.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * @author AhogeK
 * @since 2025-10-09 05:56:59
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;

        if (!validate(node.left, lower, node.val)) return false;
        if (!validate(node.right, node.val, upper)) return false;

        return true;
    }
}
