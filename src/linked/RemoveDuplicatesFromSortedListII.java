package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-16 04:59:46
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            // 跳过所有重复节点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            // 如果 pre.next == cur，说明 cur 没有重复 (即没有执行上面的循环)
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                // 删除所有重复节点
                pre.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
