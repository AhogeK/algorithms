package binarytree;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 *
 * @author AhogeK
 * @since 2025-09-19 17:18:40
 */
public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) return;
        if (node.children != null)
            for (Node child : node.children)
                dfs(child, res);
        res.add(node.val);
    }
}
