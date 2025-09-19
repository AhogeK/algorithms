package binarytree;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 *
 * @author AhogeK
 * @since 2025-09-19 17:04:21
 */
public class NAryTreePreOrderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        if (node.children != null)
            for (Node child : node.children)
                dfs(child, res);
    }
}
