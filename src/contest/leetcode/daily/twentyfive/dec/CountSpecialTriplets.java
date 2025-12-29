package contest.leetcode.daily.twentyfive.dec;

/**
 * 3583. 统计特殊三元组
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-09 14:08:53
 */
public class CountSpecialTriplets {
    public int specialTriplets(int[] nums) {
        int maxVal = 0;
        for (int x : nums) if (x > maxVal) maxVal = x;
        int[] cnt = new int[maxVal + 1];
        for (int x : nums) cnt[x]++;
        int[] left = new int[maxVal + 1];
        long ans = 0;
        for (int x : nums) {
            cnt[x]--;
            int target = x << 1;
            if (target <= maxVal) {
                int l = left[target];
                if (l > 0) {
                    int r = cnt[target];
                    if (r > 0) ans += (long) l * r;
                }
            }
            left[x]++;
        }
        return (int) (ans % 1_000_000_007);
    }
}
