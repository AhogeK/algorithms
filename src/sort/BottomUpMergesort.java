package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-03-01 16:59:47
 */
public class BottomUpMergesort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        // 子数组大小从1开始，每次翻倍
        for (int size = 1; size < n; size *= 2) {
            // 对于当前size，合并相邻的子数组
            for (int leftStart = 0; leftStart < n - size; leftStart += 2 * size) {
                int mid  = leftStart + size - 1;
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
                merge(nums, temp, leftStart, mid, rightEnd);
            }
        }
    }

    // 合并两个已排序的子数组
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // 复制到辅助数组
        for (int i = left; i <= right; i++) temp[i] = arr[i];

        int i = left; // 左边数组的起始索引
        int j = mid + 1; // 右边数组的起始索引
        int k = left; // 原始数组的当前索引

        // 合并两个子数组
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }

        // 复制左边子数组的剩余的元素（右边数组剩余元素已经在正确的位置）
        while (i <= mid) arr[k++] = temp[i++];
    }
}
