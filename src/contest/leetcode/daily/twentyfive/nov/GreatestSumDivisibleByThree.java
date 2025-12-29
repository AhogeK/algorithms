package contest.leetcode.daily.twentyfive.nov;

/**
 * 1262. 可被三整除的最大和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-23 18:39:11
 */
public class GreatestSumDivisibleByThree {

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int a1 = 10001, a2 = 10001;
        int b1 = 10001, b2 = 10001;

        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) {
                if (n < a1) {
                    a2 = a1;
                    a1 = n;
                } else if (n < a2) {
                    a2 = n;
                }
            } else if (n % 3 == 2) {
                if (n < b1) {
                    b2 = b1;
                    b1 = n;
                } else if (n < b2) {
                    b2 = n;
                }
            }
        }

        int rem = sum % 3;
        if (rem == 0) return sum;

        if (rem == 1) {
            int res = sum - a1;
            if (b1 != 10001 && b2 != 10001) {
                res = Math.max(res, sum - b1 - b2);
            }
            return res;
        }

        if (rem == 2) {
            int res = sum - b1;
            if (a1 != 10001 && a2 != 10001) {
                res = Math.max(res, sum - a1 - a2);
            }
            return res;
        }

        return 0;
    }
}
