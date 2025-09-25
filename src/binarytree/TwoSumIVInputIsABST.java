package binarytree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 653. 两数之和 IV - 输入二叉搜索树
 *
 * @author AhogeK
 * @since 2025-09-25 20:08:19
 */
public class TwoSumIVInputIsABST {
    private final Deque<TreeNode> stackLeft = new ArrayDeque<>();
    private final Deque<TreeNode> stackRight = new ArrayDeque<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        pushLeft(root);
        pushRight(root);
        int leftVal = nextLeft();
        int rightVal = nextRight();
        while (leftVal < rightVal) {
            int sum = leftVal + rightVal;
            if (sum == k) return true;
            if (sum < k) {
                if (stackLeft.isEmpty()) break;
                leftVal = nextLeft();
            } else {
                if (stackRight.isEmpty()) break;
                rightVal = nextRight();
            }
        }
        return false;
    }

    private int nextRight() {
        TreeNode node = stackRight.pop();
        int val = node.val;
        pushRight(node.left);
        return val;
    }

    private int nextLeft() {
        TreeNode node = stackLeft.pop();
        int val = node.val;
        pushLeft(node.right);
        return val;
    }

    private void pushRight(TreeNode root) {
        while (root != null) {
            stackRight.push(root);
            root = root.right;
        }
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stackLeft.push(root);
            root = root.left;
        }
    }
}
