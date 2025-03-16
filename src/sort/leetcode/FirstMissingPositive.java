package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-16 17:20:45
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将每个数值交换到正确的位置
        for (int i = 0; i < n; i++) {
            // 持续交换直到当前元素无法再移动
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 查找第一个不匹配的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
