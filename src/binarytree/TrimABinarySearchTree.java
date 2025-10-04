package binarytree;

import common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 *
 * @author AhogeK
 * @since 2025-10-03 11:06:13
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) return trimBST(root.right, low, high);
        else if (root.val > high) return trimBST(root.left, low, high);
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
