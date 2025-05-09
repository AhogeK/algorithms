package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-02-28 18:20:10
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
