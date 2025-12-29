package contest.leetcode.daily.twentyfive.july;

/**
 * 3201. 找出有效子序列的最大长度 I
 *
 * @author AhogeK
 * @since 2025-07-16 17:23:00
 */
public class FindTheMaximumLengthOfValidSubsequenceI {
    public int maximumLength(int[] nums) {
        int[][] maxLength = new int[2][2];
        for (int num : nums) {
            int parity = num % 2;
            maxLength[parity][0]++;
            maxLength[parity][1] = maxLength[1 - parity][1] + 1;
        }
        return Math.max(Math.max(maxLength[0][0], maxLength[0][1]), Math.max(maxLength[1][0], maxLength[1][1]));
    }
}
