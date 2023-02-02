package sort;

/**
 * 选择排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 16:37:42
 */
public class SelectionSort {

    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
