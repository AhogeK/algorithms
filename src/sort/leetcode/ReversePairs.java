package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-05 15:42:32
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int mergeSort(int[] nums, int left, int right, int[] temp) {
        // 基本情况：单个元素没有翻转对
        if (left >= right) return 0;

        // 分治：将数组分成两半
        int mid = left + (right - left) / 2;

        // 递归解决左右两半，并累加翻转对数量
        int count = mergeSort(nums, left, mid, temp) +
                mergeSort(nums, mid + 1, right, temp);

        // 计算跨越左右两部分的翻转对
        count += countCrossPairs(nums, left, mid, right);

        // 合并两个有序的子数组
        merge(nums, left, mid, right, temp);

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // 复制到临时数组
        for (int i = left; i <= right; i++) temp[i] = nums[i];

        // 合并回原数组
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > right) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }

    private int countCrossPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        // 对于左半部分的每个元素
        for (int i = left; i <= mid; i++) {
            // 找出右半部分的每个元素
            while (j <= right && nums[i] > 2L * nums[j]) j++;
            // j - 1 是最后一个满足条件的位置
            // 从 mid + 1 到 j - 1 的所有元素都能与 nums[i] 构成翻转对
            count += (j - (mid + 1));
        }
        return count;
    }
}
