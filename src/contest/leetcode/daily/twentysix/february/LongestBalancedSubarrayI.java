package contest.leetcode.daily.twentysix.february;

/**
 * 3719. 最长平衡子数组 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-10 23:59:59
 */
public class LongestBalancedSubarrayI {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] seen = new int[100001];
        for (int i = 0; i < n; i++) {
            int evenCnt = 0, oddCnt = 0;
            for (int j = i; j < n; j++) {
                int x = nums[j];
                if (seen[x] != i + 1) {
                    seen[x] = i + 1;
                    if ((x & 1) == 0) evenCnt++;
                    else oddCnt++;
                }
                if (evenCnt == oddCnt) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
