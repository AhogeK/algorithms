package daily.twentyfive.nov;

/**
 * 3318. 计算子数组的 x-sum I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-04 16:15:30
 */
public class FindXSumOfAllKLongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int[] cnt = new int[51];
            for (int j = i, end = i + k; j < end; j++) {
                cnt[nums[j]]++;
            }
            int sum = 0;
            for (int round = 0; round < x; round++) {
                int maxF = 0;
                int maxV = 0;
                for (int v = 50; v > 0; v--) {
                    if (cnt[v] > maxF) {
                        maxF = cnt[v];
                        maxV = v;
                    }
                }
                if (maxF == 0) break;
                sum += maxV * maxF;
                cnt[maxV] = 0;
            }
            ans[i] = sum;
        }
        return ans;
    }
}
