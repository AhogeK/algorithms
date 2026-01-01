package contest.leetcode.daily.twentysix.jan;

/**
 * 66. 加一
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-01 15:53:08
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
