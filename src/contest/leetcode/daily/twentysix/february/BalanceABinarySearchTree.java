package contest.leetcode.daily.twentysix.february;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-09 20:25:22
 */
public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
        return build(sorted, 0, sorted.size() - 1);
    }

    private void inorder(TreeNode node, List<Integer> sorted) {
        if (node == null) return;
        inorder(node.left, sorted);
        sorted.add(node.val);
        inorder(node.right, sorted);
    }

    private TreeNode build(List<Integer> sorted, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) >>> 1;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left = build(sorted, l, mid - 1);
        root.right = build(sorted, mid + 1, r);
        return root;
    }
}
