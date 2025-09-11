package binarytree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LCR 151. 彩灯装饰记录 III
 * 《剑指 Offer》第 32 - III 题：从上到下打印二叉树 III
 *
 * @author AhogeK
 * @since 2025-09-11 14:15:52
 */
public class CongShangDaoXiaDaYinErChaShuIII {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) levelList.addLast(node.val);
                else levelList.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelList);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
