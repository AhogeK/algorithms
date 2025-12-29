package contest.leetcode.daily.twentyfive.april;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AhogeK
 * @since 2025-04-16 17:02:42
 */
public class CountTheNumberOfGoodSubarrays {

    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0;
        int pairCnt = 0;

        for (int r = 0; r < n; r++) {
            // 更新当前元素的计数，并计算新增的对数
            pairCnt += cnt.merge(nums[r], 1, Integer::sum) - 1;

            // 移动左指针，直到 pairCnt < k
            while (pairCnt >= k) {
                pairCnt -= cnt.merge(nums[l++], -1, Integer::sum);
            }

            // 统计满足条件的子数组数量
            res += l;
        }

        return res;
    }
}
