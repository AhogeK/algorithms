package sort;

import sort.common.ISortingAlgorithm;

/**
 * 希尔算法
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-02 13:08:28
 */
public class ShellSort implements ISortingAlgorithm {

    public void sortArray(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int gap = nums.length / 2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                while (j - gap >= 0 && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
            gap /= 2;
        }
    }
}
