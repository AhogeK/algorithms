package sort;

import sort.common.ISortingAlgorithm;
import sort.common.SortingUtil;

/**
 * 选择排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 16:37:42
 */
public class SelectionSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            SortingUtil.swap(nums, i, minIndex);
        }
    }
}
