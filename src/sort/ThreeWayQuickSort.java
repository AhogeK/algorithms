package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-03-12 16:52:11
 */
public class ThreeWayQuickSort implements ISortingAlgorithm {

    private static final int INSERTION_THRESHOLD = 16; // 插入排序阈值

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小数组使用插入排序优化
        if (right - left < INSERTION_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        // 调用三数取中算法获取枢轴索引
        int pivotIndex = medianOfThree(nums, left, (left + right) >>> 1, right);
        swap(nums, left, pivotIndex); // 将枢轴交换到首位

        int pivotValue = nums[left];
        int lt = left;      // 小于区的右边界
        int gt = right;     // 大于区的左边界
        int i = left + 1;   // 当前元素指针

        // 三向分区操作（Dijkstra三路划分法）
        while (i <= gt) {
            int cmp = nums[i] - pivotValue;
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }

        // 递归处理子区间
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt + 1, right);
    }

    private int medianOfThree(int[] nums, int a, int b, int c) {
        int aVal = nums[a], bVal = nums[b], cVal = nums[c];

        // 异或运算判断中间值 (等价于两次比较)
        if ((aVal < bVal) ^ (aVal < cVal)) return a;
        if ((bVal > aVal) ^ (bVal > cVal)) return b;
        return c;
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= left && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
