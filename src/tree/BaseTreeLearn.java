package tree;

import common.TreeNode;

/**
 * @author AhogeK
 * @since 2025-04-16 08:02:42
 */
public class BaseTreeLearn {

    public static void main(String[] args) {
        BaseTreeLearn tree = new BaseTreeLearn();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));
        int key = 2;
        System.out.println(tree.searchRecursive(root, key));
        System.out.println(tree.searchIterative(root, key));

        root = null;
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int val : values) {
            root = tree.insert(root, val);
        }

        System.out.println(root);

        System.out.println(tree.deleteNode(root, 10));

        System.out.println("中序遍历：");
        tree.inorderTraversal(root);
    }

    /**
     * 二叉搜索树搜索(递归实现)
     *
     * @param root 树根节点
     * @param key  待搜索的节点值
     * @return 搜索到的节点
     */
    public TreeNode searchRecursive(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }

        return key < root.val ? searchRecursive(root.left, key) : searchRecursive(root.right, key);
    }

    /**
     * 树搜索(迭代实现)更节省栈空间
     *
     * @param root 树根节点
     * @param key  待搜索的节点值
     * @return 搜索到的节点
     */
    public TreeNode searchIterative(TreeNode root, int key) {
        while (root != null && root.val != key) {
            root = key < root.val ? root.left : root.right;
        }
        return root;
    }

    /**
     * 插入操作
     *
     * @param root 树根节点
     * @param key  待插入的节点值
     * @return 插入后的树根节点
     */
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);

        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    /**
     * 删除操作（最复杂）
     *
     * @param root 根节点
     * @param key  待删除的节点值
     * @return 删除后的树根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 无子节点或只有一个子节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 有两个子节点
            // 找到右子树的最小节点
            TreeNode successor = findMin(root.right);
            // 用后继节点值替换
            root.val = successor.val;
            // 删除后继节点
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    /**
     * 中序遍历
     *
     * @param root 树根节点
     */
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
