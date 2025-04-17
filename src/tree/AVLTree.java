package tree;

/**
 * @author AhogeK
 * @since 2025-04-17 13:39:08
 */
public class AVLTree {
    private Node root;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // 插入测试
        int[] keys = {10, 20, 30, 40, 50, 25};
        for (int key : keys) {
            tree.insert(key);
        }

        // 中序遍历输出（验证平衡性）
        tree.printInOrder(); // 输出：10 20 25 30 40 50
    }

    /**
     * 求节点的高度(空节点高度为0)
     *
     * @param node 节点
     * @return 节点的高度
     */
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 更新节点高度
     *
     * @param node 节点
     */
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 获取平衡因子
     *
     * @param node 节点
     * @return 平衡因子
     */
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    /**
     * 右旋(LL)
     * 对给定的节点进行右旋转操作，并返回旋转后的新根节点。
     * 右旋转操作通常用于平衡二叉搜索树（如AVL树）中，以调整树的结构。
     *
     * @param y 需要进行右旋转的节点
     * @return 旋转后的新根节点
     */
    private Node rightRotate(Node y) {
        // 获取y的左子节点x，x将成为旋转后的新根节点
        Node x = y.left;
        // 获取x的右子节点T2，T2将成为y的左子节点
        Node T2 = x.right;

        // 进行旋转操作：将x的右子节点指向y，将y的左子节点指向T2
        x.right = y;
        y.left = T2;

        // 更新y和x的高度，确保树的高度信息正确
        updateHeight(y);
        updateHeight(x);

        // 返回旋转后的新根节点x
        return x;
    }

    /**
     * 左旋(RR)
     * 对给定的节点进行左旋转操作，并返回旋转后的新根节点。
     *
     * @param x 需要进行左旋转的节点
     * @return 旋转后的新根节点
     */
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    /**
     * 插入节点
     *
     * @param key 待插入的节点值
     */
    private void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // 如果key已经存在，不进行插入操作
            return node;
        }

        updateHeight(node);
        int balance = getBalance(node);

        // LL
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // LR
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }
}
