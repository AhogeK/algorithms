package binarytree;

import common.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 *
 * @author AhogeK
 * @since 2025-09-21 21:49:21
 */
public class SearchInABinarySearchTree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val == val) return root;
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }
}
