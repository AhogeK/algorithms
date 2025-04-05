package linked;

import common.ListNode;

/**
 * @author AhogeK
 * @since 2025-04-05 21:57:37
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedListII solution = new ReverseLinkedListII();
        ListNode reversedHead = solution.reverseBetween(head, 2, 4);
        System.out.println(reversedHead);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 处理特殊情况
        if (head == null || left == right) {
            return head;
        }

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 找到反转部分的前一个节点
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 当前节点初始化为left位置
        ListNode curr = pre.next;
        ListNode next;

        // 执行（right - left）次反转操作
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
