package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-15 05:57:55
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode lastSorted = head; // 已排序部分的最后一个节点
        ListNode curr = head.next; // 当前待排序节点

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                // 当前节点大于已排序部分最后一个节点，直接扩展
                lastSorted = lastSorted.next;
            } else {
                // 需要插入，从头开始寻找插入位置
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) prev = prev.next;
                // 执行插入操作（此时prev.val <= curr.val但prev.next.val > curr.val）
                lastSorted.next = curr.next; // lastSorted去连接当前的下一个待排元素(临时将curr从链表中摘除)
                curr.next = prev.next; // curr被摘除，curr.next从原先的null变为大于curr的值也就是上面说的prev.next
                prev.next = curr; // prev.val <= curr.val的，所以最后重新连上即可
            }
            // 移动到下一个待排序节点
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}
