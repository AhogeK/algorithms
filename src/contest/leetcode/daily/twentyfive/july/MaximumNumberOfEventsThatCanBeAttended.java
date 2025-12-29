package contest.leetcode.daily.twentyfive.july;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 *
 * @author AhogeK
 * @since 2025-07-07 13:35:02
 */
public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int res = 0;
        int eventIdx = 0;
        int lastDay = 0;
        for (int[] e : events) {
            lastDay = Math.max(lastDay, e[1]);
        }
        for (int day = 1; day <= lastDay; day++) {
            while (eventIdx < n && events[eventIdx][0] == day) {
                minHeap.offer(events[eventIdx++][1]);
            }
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }
        return res;
    }
}
