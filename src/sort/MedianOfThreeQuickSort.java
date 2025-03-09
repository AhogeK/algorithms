package sort;

import sort.common.ISortingAlgorithm;

import static sort.common.SortingUtil.swap;

/**
 * @author AhogeK
 * @since 2025-03-09 15:50:58
 */
public class MedianOfThreeQuickSort implements ISortingAlgorithm {

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
        // 使用三数取中法选择pivot
        int mid = left + (right - left) / 2;

        // 将三个元素按顺序排列
        // 保证 nums[left] <= nums[mid] <= nums[right]
        if (nums[left] > nums[mid]) swap(nums, left, mid);
        if (nums[left] > nums[right]) swap(nums, left, right);
        if (nums[mid] > nums[right]) swap(nums, mid, right);

        // 此时 nums[mid] 是三个数种的中间值
        // 将中间值与 left + 1 位置交换，作为pivot
        swap(nums, mid, left + 1);

        // 使用 left + 1 位置的元素作为 pivot
        int pivot = nums[left + 1];
        swap(nums, left, left + 1);

        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }

        swap(nums, left, lt);
        return lt;
    }
}
