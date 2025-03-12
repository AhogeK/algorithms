package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-12 21:52:30
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int lt = 0; // 0区的右边界
        int gt = nums.length - 1; // 2区的左边界
        int i = 0; // 当前遍历指针

        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt++, i++); // 将0交换到左区
            } else if (nums[i] == 2) {
                swap(nums, i, gt--); // 将2交换到右区
            } else {
                i++; // 1保持不动
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
