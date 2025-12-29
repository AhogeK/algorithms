package contest.leetcode.daily.twentyfive.oct;

import java.util.List;

/**
 * 3350. 检测相邻递增子数组 II
 *
 * @author AhogeK
 * @since 2025-10-15 15:45:29
 */
public class AdjacentIncreasingSubarraysDetectionII {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        Integer[] arr = nums.toArray(new Integer[0]);
        int size = 0;
        int cache = 0;
        int max = 1;
        int prev = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > prev) size++;
            else {
                int selfSplit = size >> 1;
                int adjacentPair = Math.min(cache, size);
                if (selfSplit > max) max = selfSplit;
                if (adjacentPair > max) max = adjacentPair;
                cache = size;
                size = 1;
            }
            prev = num;
        }
        int selfSplit = size >> 1;
        int adjacentPair = Math.min(cache, size);
        if (selfSplit > max) max = selfSplit;
        if (adjacentPair > max) max = adjacentPair;
        return max;
    }
}
