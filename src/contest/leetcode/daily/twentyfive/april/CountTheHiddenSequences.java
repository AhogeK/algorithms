package contest.leetcode.daily.twentyfive.april;

/**
 * 2145. 统计隐藏数组数目
 *
 * @author AhogeK
 * @since 2025-04-21 14:08:56
 */
public class CountTheHiddenSequences {
    /**
     * differences[i] = hidden[i + 1] - hidden[i]
     * differences[0] = hidden[1] - hidden[0]
     * 所以 hidden[1] = hidden[0] + differences[0]
     *    -> hidden[2] = hidden[1] + differences[1] = hidden[0] + differences[0] + differences[1]
     * 所以 hidden[i] = hidden[0] + differences[0] + differences[1] + ... + differences[i - 1]
     * 假设 hidden[0] = x, 那么 hidden[i] = x + differences[0] + differences[1] + ... + differences[i - 1]
     * 设x后面所有的前缀和为prefix，那么 hidden[i] = x + prefix[i], 也可以得出 lower <= x + prefix[i] <= upper
     * 就可以求所有的 x 的个数，然后根据区间交集的经典原理求出区间交集的个数即可
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;
        long sum = 0;
        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        long left = lower - min;
        long right = upper - max;
        return (int) Math.max(0, right - left + 1);
    }
}
