package binarytree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. 二叉搜索树迭代器
 *
 * @author AhogeK
 * @since 2025-09-23 19:37:08
 */
public class BinarySearchTreeIterator {
    class BSTIterator {
        private Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode cur = stack.pop();
            if (cur.right != null) pushLeft(cur.right);
            return cur.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
