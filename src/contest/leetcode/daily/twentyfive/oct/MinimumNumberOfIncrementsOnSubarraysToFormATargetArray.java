package contest.leetcode.daily.twentyfive.oct;

/**
 * 1526. 形成目标数组的子数组最少增加次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-10-30 20:08:22
 */
public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for (int i = 1; i < target.length; i++) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }
}
