package priorityqueue;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 347. 前 K 个高频元素
 *
 * @author AhogeK
 * @since 2025-06-23 23:00:49
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else {
                pq.add(new int[]{nums[i - 1], count});
                count = 1;
            }
        }
        pq.add(new int[]{nums[n - 1], count});
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = Objects.requireNonNull(pq.poll())[0];
        return res;
    }
}
