package contest.leetcode.daily.twentyfive.dec;

/**
 * 3577. 统计计算机解锁顺序排列数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-10 19:00:22
 */
public class CountTheNumberOfComputerUnlockingPermutations {
    public int countPermutations(int[] complexity) {
        int mod = 1000000007;
        int n = complexity.length;
        for (int i = 1; i < n; i++)
            if (complexity[i] <= complexity[0])
                return 0;
        int ans = 1;
        for (int i = 2; i < n; i++)
            ans = (int) ((long) ans * i % mod);
        return ans;
    }
}
