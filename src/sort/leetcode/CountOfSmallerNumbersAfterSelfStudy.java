package sort.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-06 17:10:33
 */
public class CountOfSmallerNumbersAfterSelfStudy {

    // 辅助类，保存元素值和元素索引
    private class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);

        // 创建元素-索引对数组
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        // 执行归并排序并计数
        mergeSort(pairs, 0, n - 1, result);

        return Arrays.asList(result);
    }

    private void mergeSort(Pair[] pairs, int left, int right, Integer[] result) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(pairs, left, mid, result);
        mergeSort(pairs, mid + 1, right, result);
        merge(pairs, left, mid, right, result);
    }

    private void merge(Pair[] pairs, int left, int mid, int right, Integer[] result) {
        Pair[] temp = new Pair[right - left + 1];

        int i = left;       // 左子数组指针
        int j = mid + 1;    // 右子数组指针
        int k = 0;          // 临时数组指针

        // 合并两个有序子数组
        while (i <= mid && j <= right) {
            if (pairs[i].value <= pairs[j].value) {
                // 当前左子数组元素小于等于右子数组元素
                // j - (mid + 1) 表示右子数组中已处理的元素个数（均小于当前元素）
                result[pairs[i].index] += (j - (mid + 1));
                temp[k++] = pairs[i++];
            } else {
                // 右子数组元素小于左子数组元素，无需计数（后续统一结算）
                temp[k++] = pairs[j++];
            }
        }

        // 处理左子数组剩余元素
        while (i <= mid) {
            // 右子数组已全部处理，这些元素都小于当前元素
            result[pairs[i].index] += (j - (mid + 1));
            temp[k++] = pairs[i++];
        }

        // 处理右子数组剩余元素
        while (j <= right) {
            temp[k++] = pairs[j++];
        }

        // 将临时数组复制回原数组
        for (int p = 0; p < temp.length; p++) {
            pairs[left + p] = temp[p];
        }
    }
}
