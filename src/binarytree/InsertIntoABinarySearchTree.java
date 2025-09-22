package binarytree;

import common.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author AhogeK
 * @since 2025-09-22 19:52:16
 */
public class InsertIntoABinarySearchTree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (val < root.val) root.left = insertIntoBST(root.left, val);
            else root.right = insertIntoBST(root.right, val);
            return root;
        }
    }
}
