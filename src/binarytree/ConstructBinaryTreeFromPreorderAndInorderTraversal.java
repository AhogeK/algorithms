package binarytree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author AhogeK
 * @since 2025-09-19 16:11:11
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int[] preorder;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = preorder.length;
        inorderIndexMap = HashMap.newHashMap(n);
        for (int i = 0; i < n; i++)
            inorderIndexMap.put(inorder[i], i);
        return buildSubtree(0, n - 1, 0, n - 1);
    }

    private TreeNode buildSubtree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;
        root.left = buildSubtree(preStart + 1, preStart + leftTreeSize, inStart, inRootIndex - 1);
        root.right = buildSubtree(preStart + leftTreeSize + 1, preEnd, inRootIndex + 1, inEnd);
        return root;
    }
}
