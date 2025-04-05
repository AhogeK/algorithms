package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-05 16:13:44
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5)))));
        System.out.println(solution.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        // 处理边界情况
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null; // 以反转部分的头节点
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
