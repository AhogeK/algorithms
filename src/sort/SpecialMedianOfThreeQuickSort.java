package sort;

import sort.common.ISortingAlgorithm;

import static sort.common.SortingUtil.swap;

/**
 * @author AhogeK
 * @since 2025-03-09 16:31:51
 */
public class SpecialMedianOfThreeQuickSort implements ISortingAlgorithm {

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
        if (right - left > 2) {
            int mid = left + (right - left) / 2;
            int medianIndex = medianOfThree(nums, left, mid, right);
            // 将中间值与left位置交换
            swap(nums, left, medianIndex);
        }

        int pivot = nums[left];
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

    private int medianOfThree(int[] nums, int a, int b, int c) {
        // 使用异或运算判断中间值
        // 如果a大于b和c中的一个（且仅一个），那么a就是中间值
        if ((nums[a] > nums[b]) ^ (nums[a] > nums[c])) return a;

        // 如果b小于a和c中的一个（且仅一个），那么b就是中间值
        else if ((nums[b] < nums[a]) ^ (nums[b] < nums[c])) return b;

        // 否则c是中间值
        else return c;
    }
}
