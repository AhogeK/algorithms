package binarysearch;

/**
 * 「力扣」第 1300 题：转变数组后最接近目标值的数组和
 * <a href="https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/">题目链接</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-29 18:36:15
 */
public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        // 取最大值作为右边界
        for (int num : arr) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);
            if (sum < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (Math.abs(target - sum1) <= Math.abs(target - sum2)) {
            return left - 1;
        }
        return left;
    }

    public int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }
}
