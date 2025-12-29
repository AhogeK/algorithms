package contest.leetcode.daily.twentyfive.dec;

/**
 * 3578. 统计极差最大为 K 的分割方式数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-06 13:25:49
 */
public class CountPartitionsWithMaxMinDifferenceAtMostK {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int mod = 1_000_000_007;
        int[] sum = new int[n + 2];
        sum[1] = 1;
        int[] qMax = new int[n];
        int hMax = 0;
        int tMax = 0;
        int[] qMin = new int[n];
        int hMin = 0;
        int tMin = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            while (hMax < tMax && nums[qMax[tMax - 1]] <= val) tMax--;
            qMax[tMax++] = i;
            while (hMin < tMin && nums[qMin[tMin - 1]] >= val) tMin--;
            qMin[tMin++] = i;
            while (true) {
                int maxVal = nums[qMax[hMax]];
                int minVal = nums[qMin[hMin]];
                if (maxVal - minVal <= k) break;
                if (qMax[hMax] == left) hMax++;
                if (qMin[hMin] == left) hMin++;
                left++;
            }
            int currentDp = sum[i + 1] - sum[left];
            if (currentDp < 0) currentDp += mod;
            sum[i + 2] = sum[i + 1] + currentDp;
            if (sum[i + 2] >= mod) sum[i + 2] -= mod;
        }
        int ans = sum[n + 1] - sum[n];
        return ans < 0 ? ans + mod : ans;
    }
}
