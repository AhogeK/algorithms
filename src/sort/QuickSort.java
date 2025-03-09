package sort;

import sort.common.ISortingAlgorithm;

import static sort.common.SortingUtil.swap;

/**
 * @author AhogeK
 * @since 2025-03-07 15:32:15
 */
public class QuickSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, left, right);

        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        // 循环不变量：lt 即 less than
        // [left + 1, lt] < pivot
        // [lt + 1, i) >= pivot
        int lt = left;
        // 注意这里取等号
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 交换当前元素与lt的位置
                lt++;
                swap(nums, i, lt);
            }
        }
        // 最后这一步要记得交换切分元素
        swap(nums, left, lt);
        return lt;
    }
}
