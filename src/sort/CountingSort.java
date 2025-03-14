package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-03-14 01:35:59
 */
public class CountingSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums.length == 0) return;

        // 找最大值
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }

        // 初始化计数数组
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        // 累加计数（计算最终位置）
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 反向填充结果数组
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            // 最小就是只出现1次，放在下标0，所以-1
            output[count[current] - 1] = current;
            count[current]--;
        }

        // 拷贝回原数组，使用System.arraycopy是因为`System.arraycopy` 是
        // JVM 内置的本地方法（native method），底层通过内存块复制实现，
        // 时间复杂度 $O(1)$
        System.arraycopy(output, 0, nums, 0, nums.length);
    }
}
