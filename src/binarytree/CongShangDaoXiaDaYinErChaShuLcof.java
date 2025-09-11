package binarytree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LCR 149. 彩灯装饰记录 I
 * 《剑指 Offer》第 32 - I 题：从上到下打印二叉树
 *
 * @author AhogeK
 * @since 2025-09-11 13:49:20
 */
public class CongShangDaoXiaDaYinErChaShuLcof {
    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++)
            res[i] = resList.get(i);
        return res;
    }
}
