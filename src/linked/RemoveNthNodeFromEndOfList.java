package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-15 12:38:33
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        // 快指针先走n+1步（此时与慢指针的间隔就是n+1，因为要删除的目标在倒数第 n+1 个节点）
        for (int i = 0; i < n + 1; i++) fast = fast.next;

        // 同步前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除操作
        slow.next = slow.next.next;

        return dummy.next;
    }
}
