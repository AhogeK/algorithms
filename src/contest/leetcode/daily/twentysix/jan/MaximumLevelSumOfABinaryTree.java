package contest.leetcode.daily.twentysix.jan;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1161. 最大层内元素和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-06 17:32:18
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int level = 1;
        int bestLevel = 1;
        long bestSum = Long.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            if (sum > bestSum) {
                bestSum = sum;
                bestLevel = level;
            }

            level++;
        }

        return bestLevel;
    }
}
