package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-16 05:32:35
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        // 创建两个虚拟头节点
        ListNode smallerDummy = new ListNode(0);
        ListNode largerDummy = new ListNode(0);

        // 两个链表的当前节点指针
        ListNode smaller = smallerDummy;
        ListNode larger = largerDummy;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }

        // 连接两个链表
        larger.next = null;
        smaller.next = largerDummy.next;

        return smallerDummy.next;
    }
}
