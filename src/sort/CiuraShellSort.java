package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-02-27 09:13:32
 */
public class CiuraShellSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int[] ciuraGaps = {701, 301, 132, 57, 23, 10, 4, 1};

        for (int gap : ciuraGaps) {
            if (gap > nums.length) continue;
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                while (j >= gap && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
        }
    }
}
