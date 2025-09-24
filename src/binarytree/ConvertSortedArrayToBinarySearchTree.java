package binarytree;

import common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author AhogeK
 * @since 2025-09-24 17:04:28
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
