package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-14 09:01:52
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 计算链表长度
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // 计算实际旋转次数
        k %= n;
        if (k == 0) return head;

        // 找到新的头结点的前一个节点
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) newTail = newTail.next;

        // 调整指针
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}
