package daily.twentyfive;


import common.TreeNode;

/**
 * 1123. 最深叶节点的最近公共祖先
 *
 * @author AhogeK
 * @since 2025-04-04 16:18:23
 */
public class LowestCommonAncestorOfDeepestLeaves {
    private TreeNode ans;
    private int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }

        // 后序遍历：先左后右再根
        int leftMaxDepth = dfs(node.left, depth + 1);
        int rightMaxDepth = dfs(node.right, depth + 1);

        // 如果左右子树最深叶节点深度相同且等于全局最深叶节点深度，则当前节点为最深叶节点LCA
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth) {
            ans = node;
        }

        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        TreeNode node2 = new TreeNode(3);
        root.right = node2;
        TreeNode node3 = new TreeNode(2);
        node1.right = node3;
        LowestCommonAncestorOfDeepestLeaves lca = new LowestCommonAncestorOfDeepestLeaves();
        System.out.println(lca.lcaDeepestLeaves(root));
    }
}
