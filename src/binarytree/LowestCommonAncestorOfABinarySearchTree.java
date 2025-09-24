package binarytree;

import common.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author AhogeK
 * @since 2025-09-24 18:14:16
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int currVal = node.val;
            if (pVal > currVal && qVal > currVal) node = node.right;
            else if (pVal < currVal && qVal < currVal) node = node.left;
            else return node;
        }
        return null;
    }
}
