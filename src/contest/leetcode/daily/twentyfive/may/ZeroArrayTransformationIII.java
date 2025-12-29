package contest.leetcode.daily.twentyfive.may;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 3362. 零数组变换 III
 *
 * @author AhogeK
 * @since 2025-05-22 19:53:58
 */
public class ZeroArrayTransformationIII {

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] count = new int[n];
        for (int[] q : queries)
            count[q[0]]++;
        int[][] grouped = new int[n][];
        for (int i = 0; i < n; i++)
            grouped[i] = new int[count[i]];
        for (int[] q : queries) {
            int start = q[0];
            grouped[start][--count[start]] = q[1];
        }
        int[] dp = new int[n + 2];
        int sum = 0;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            for (int r : grouped[i])
                pq.offer(r);
            while (!pq.isEmpty() && sum + dp[i] < nums[i] && pq.peek() >= i) {
                dp[i]++;
                dp[pq.poll() + 1]--;
            }
            sum += dp[i];
            if (sum < nums[i])
                return -1;
        }
        return pq.size();
    }
}
