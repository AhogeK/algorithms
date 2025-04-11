package linked;

import common.ListNode;

/**
 * 328. 奇偶链表
 *
 * @author AhogeK
 * @since 2025-04-11 08:39:32
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 初始化奇数节点指针和偶数节点指针
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // 遍历链表，将奇数节点和偶数节点分别连接起来
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
