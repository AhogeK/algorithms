package binarytree;

import common.TreeNode;

/**
 * 449. 序列化和反序列化二叉搜索树
 *
 * @author AhogeK
 * @since 2025-09-23 19:49:45
 */
public class SerializeAndDeserializeBst {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            if (!sb.isEmpty()) sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        private void preOrder(TreeNode node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.val).append(",");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }

        private int idx;
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            String[] arr = data.split(",");
            int n = arr.length;
            int[] vals = new int[n];
            for (int i = 0; i < n; i++)
                vals[i] = Integer.parseInt(arr[i]);
            idx = 0;
            return build(vals, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode build(int[] vals, int lower, int upper) {
            if (idx == vals.length) return null;
            int v = vals[idx];
            if (v < lower || v > upper) return null;
            idx++;
            TreeNode node = new TreeNode(v);
            node.left = build(vals, lower, v);
            node.right = build(vals, v, upper);
            return node;
        }
    }
}
