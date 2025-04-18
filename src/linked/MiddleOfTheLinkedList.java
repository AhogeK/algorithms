package linked;

import common.ListNode;

/**
 * 876. 链表的中间结点
 *
 * @author AhogeK
 * @since 2025-04-18 10:16:13
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
