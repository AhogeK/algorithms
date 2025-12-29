package contest.leetcode.daily.twentyfive.oct;

/**
 * 3289. 数字小镇中的捣蛋鬼
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-10-31 02:20:21
 */
public class TheTwoSneakyNumberOfDigitVille {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] seen = new boolean[100];
        int[] ans = new int[2];
        int k = 0;
        for (int x : nums) {
            if (seen[x])
                ans[k++] = x;
            else
                seen[x] = true;
            if (k == 2)
                return ans;
        }
        return ans;
    }
}
