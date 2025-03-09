package sort;

import sort.common.ISortingAlgorithm;

import java.util.Random;

import static sort.common.SortingUtil.swap;

/**
 * @author AhogeK
 * @since 2025-03-09 15:41:55
 */
public class RandomWayQuickSort implements ISortingAlgorithm {

    private final Random random = new Random();

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
        // 随机选择一个索引作为pivot
        int randomIndex = left + random.nextInt(right - left + 1);
        // 将随机选中的元素与最左边元素交换
        swap(nums, left, randomIndex);

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
}
