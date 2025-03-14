package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-03-14 16:35:48
 */
public class LSDRadixSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        // 获取最大值与最大位数
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }

        int maxDigit;
        if (max == 0) maxDigit = 1;
        else maxDigit = (int) (Math.log10(max) + 1);

        // 初始化exp（指数，代表当前处理位：1-个位，10-十位）
        int exp = 1;
        int[] output = new int[nums.length];

        // 逐位排序
        while (maxDigit-- > 0) {
            int[] count = new int[10]; // 十进制 0-9

            // 统计当前位出现的个数
            for (int num : nums) {
                int digit = (num / exp) % 10;
                count[digit]++;
            }

            // 计算累加次数
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 反向填充（关键稳定性保证）
            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                output[--count[digit]] = nums[i];
            }

            // 复制回原数组
            System.arraycopy(output, 0, nums, 0, nums.length);

            // 处理下一位
            exp *= 10;
        }
    }
}
