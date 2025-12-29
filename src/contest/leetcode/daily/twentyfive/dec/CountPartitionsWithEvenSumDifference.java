package contest.leetcode.daily.twentyfive.dec;

/**
 * 3432. 统计元素和差值为偶数的分区方案
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-05 10:57:39
 */
public class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum % 2 == 0)
            return nums.length - 1;
        else return 0;
    }
}
