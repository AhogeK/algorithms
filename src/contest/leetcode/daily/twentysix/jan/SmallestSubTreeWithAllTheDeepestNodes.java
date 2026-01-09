package contest.leetcode.daily.twentysix.jan;

import common.TreeNode;

/**
 * 865. 具有所有最深节点的最小子树
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-09 19:05:59
 */
public class SmallestSubTreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node();
    }

    private Result dfs(TreeNode root) {
        if (root == null) return new Result(null, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.height() > right.height()) return new Result(left.node(), left.height() + 1);
        else if (right.height() > left.height()) return new Result(right.node(), right.height() + 1);
        else return new Result(root, left.height() + 1);
    }

    private record Result(TreeNode node, int height) {
    }
}
