package linked;

import common.ListNode;

/**
 * 142. 环形链表 II
 *
 * @author AhogeK
 * @since 2025-04-18 14:22:22
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 说明有环
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // 找到环入口
                return slow;
            }
        }

        return null;
    }
}
