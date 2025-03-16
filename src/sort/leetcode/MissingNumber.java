package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-16 21:49:22
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        long total = (long) n * (n + 1) / 2; // 避免整数溢出
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) (total - sum);
    }
}
