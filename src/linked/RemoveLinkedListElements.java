package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-10 09:50:46
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 当前遍历节点指针
        ListNode curr = dummy;

        // 遍历链表
        while (curr.next != null) {
            // 如果下一个节点的值等于要删除的值
            if (curr.next.val == val) {
                // 删除下一个节点
                curr.next = curr.next.next;
            } else {
                // 否则移动到下一个节点
                curr = curr.next;
            }
        }

        // 返回新的头节点
        return dummy.next;
    }
}
