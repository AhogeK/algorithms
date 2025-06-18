package priorityqueue;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并 K 个升序链表
 *
 * @author AhogeK
 * @since 2025-06-18 21:04:07
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists)
            if (node != null)
                pq.offer(node);
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = node;
            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}
