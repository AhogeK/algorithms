package backtracking;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-20 17:06:02
 */
public class PathSumII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) res.add(new ArrayList<>(path));
        else {
            dfs(node.left, target);
            dfs(node.right, target);
        }
        path.removeLast();
    }
}
