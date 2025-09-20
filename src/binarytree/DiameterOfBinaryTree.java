package binarytree;

import common.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author AhogeK
 * @since 2025-09-20 16:33:48
 */
public class DiameterOfBinaryTree {
    class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return maxDiameter;
        }

        private int depth(TreeNode node) {
            if (node == null) return 0;
            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);
            maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
