package binarytree;

import common.ListNode;
import common.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @author AhogeK
 * @since 2025-09-24 17:10:59
 */
public class ConvertSortedListToBinarySearchTree {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        current = head;
        return build(0, length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode leftChild = build(left, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode rightChild = build(mid + 1, right);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
