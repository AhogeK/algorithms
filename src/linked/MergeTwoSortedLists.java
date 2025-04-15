package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-15 13:47:30
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 同时遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 连接剩余的链表
        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }
}
