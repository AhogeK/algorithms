package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-09 17:09:28
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left == right) return nums[left];

        // 随机选择pivot
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(nums, left, randomIndex);

        // 三向切分
        int[] equalRange = threeWayPartition(nums, left, right);
        int ltPivot = equalRange[0]; // less than pivot的右边界
        int gtPivot = equalRange[1]; // greater than pivot的左边界

        // 根据目标索引位置，决定在哪个区域继续查找
        if (targetIndex >= ltPivot && targetIndex <= gtPivot) {
            // 目标在等于pivot的区域内，直接返回pivot值
            return nums[ltPivot];
        } else if (targetIndex < ltPivot) {
            // 目标在小于pivot的区域
            return quickSelect(nums, left, ltPivot - 1, targetIndex);
        } else {
            // 目标在大于pivot的区域
            return quickSelect(nums, gtPivot + 1, right, targetIndex);
        }
    }

    /**
     * 三向切分
     *
     * @return 返回等于pivot区域的[开始索引, 结束索引]
     */
    private int[] threeWayPartition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lt = left;      // less than pivot右边界（初始为left）
        int i = left + 1;   // 当前处理的元素
        int gt = right;     // greater than pivot左边界（初始为right）

        // 将数组分成三部分：<pivot, =pivot, >pivot
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
                // 注意：这里i不增加，因为交换后i位置的元素还未处理
            } else {
                // nums[i] == pivot
                i++;
            }
        }

        return new int[]{lt, gt};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
