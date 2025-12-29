package contest.leetcode.daily.twentyfive.nov;

import common.ListNode;

/**
 * 3217. 从链表中移除在数组中存在的节点
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-01 08:39:24
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] del = new boolean[100001];
        for (int x : nums) del[x] = true;
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null)
            if (del[p.next.val]) p.next = p.next.next;
            else p = p.next;
        return dummy.next;
    }
}
