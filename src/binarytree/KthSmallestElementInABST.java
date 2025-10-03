package binarytree;

import common.TreeNode;

/**
 * 230. 二叉搜索树中第 K 小的元素
 *
 * @author AhogeK
 * @since 2025-10-03 10:39:34
 */
public class KthSmallestElementInABST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
