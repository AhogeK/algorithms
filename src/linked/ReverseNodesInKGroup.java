package linked;

import common.ListNode;

/**
 * 第 25 题：K 个一组翻转链表
 *
 * @author AhogeK
 * @since 2025-04-11 07:05:23
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化指针
        ListNode prev = dummy;

        while (true) {
            // 检查是否有 k 个节点
            ListNode kth = getKth(prev, k);
            if (kth == null) break;

            // 当前组的第一个节点和下一组的起始节点
            ListNode first = prev.next;
            ListNode nextStart = kth.next;

            // 断开当前组与后续节点的连接
            kth.next = null;

            // 反转当前组，并连接到前一个节点
            prev.next = reverseList(first);

            // 连接当前组的尾节点（翻转后的 first）到下一组的起始节点
            first.next = nextStart;

            prev = first;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
