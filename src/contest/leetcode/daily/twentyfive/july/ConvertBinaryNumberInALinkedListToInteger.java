package contest.leetcode.daily.twentyfive.july;

import common.ListNode;

/**
 * 1290. 二进制链表转整数
 *
 * @author AhogeK
 * @since 2025-07-14 23:43:40
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }
}
