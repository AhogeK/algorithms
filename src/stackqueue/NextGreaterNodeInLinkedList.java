package stackqueue;

import common.ListNode;

/**
 * 1019. 链表中的下一个更大节点
 *
 * @author AhogeK
 * @since 2025-05-24 05:03:50
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int[] values = new int[length];
        curr = head;
        for (int i = 0; i < length; i++) {
            values[i] = curr.val;
            curr = curr.next;
        }
        int[] result = new int[length];
        int[] stack = new int[length];
        int top = -1;
        for (int i = 0; i < length; i++) {
            while (top >= 0 && values[i] > values[stack[top]])
                result[stack[top--]] = values[i];
            stack[++top] = i;
        }
        return result;
    }
}
