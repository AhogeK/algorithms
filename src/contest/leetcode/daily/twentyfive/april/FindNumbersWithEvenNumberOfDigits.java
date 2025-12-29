package contest.leetcode.daily.twentyfive.april;

/**
 * 1295. 统计位数为偶数的数字
 *
 * @author AhogeK
 * @since 2025-04-30 22:02:08
 */
public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums)
            if (hasEvenDigits(num))
                res++;
        return res;
    }

    private boolean hasEvenDigits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count % 2 == 0;
    }
}
