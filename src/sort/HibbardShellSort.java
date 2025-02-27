package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-02-23 12:42:08
 */
public class HibbardShellSort implements ISortingAlgorithm {

    /**
     * Hibbard序列 2^k - 1 (1, 3, 7, 15)
     * 数学表达式：
     * $$h\_k = 2^k - 1 \quad (序列递减顺序)$$
     */
    @Override
    public void sortArray(int[] nums) {
        int k = (int) (Math.log(nums.length) / Math.log(2));
        while (k >= 1) {
            int gap = (int) (Math.pow(2, k) - 1);
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                while (j >= gap && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
            k--;
        }
    }
}
