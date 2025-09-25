package binarytree;

import common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author AhogeK
 * @since 2025-09-25 20:00:21
 */
public class ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.right);
        node.val += sum;
        sum = node.val;
        traverse(node.left);
    }
}
