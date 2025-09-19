package binarytree;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 *
 * @author AhogeK
 * @since 2025-09-19 18:45:21
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                layer.add(curr.val);
                if (curr.children != null)
                    for (Node child : curr.children)
                        queue.offer(child);
            }
            res.add(layer);
        }
        return res;
    }
}
