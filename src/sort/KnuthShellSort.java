package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-02-25 14:45:05
 */
public class KnuthShellSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int gap = 1;
        while (gap < nums.length / 3) {
            gap = gap * 3 + 1; // 生成最大可用间隔
        }

        while (gap >= 1) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                while (j >= gap && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
            gap = (gap - 1) / 3;
        }
    }
}
