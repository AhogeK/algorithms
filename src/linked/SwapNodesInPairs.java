package linked;

import common.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * @author AhogeK
 * @since 2025-04-10 10:07:36
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev指针，指向待交换两个节点的前一个节点
        ListNode prev = dummy;

        // 当链表表还有至少两个节点可以交换时
        while (head != null && head.next != null) {
            // 定位待交换的两个节点
            ListNode first = head;
            ListNode second = head.next;

            // 进行交换
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 更换指针，为下一次交换作准备
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
