package array;

import java.util.Arrays;

/**
 * @author AhogeK
 * @since 2025-04-03 18:40:48
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // 首先对数组进行排序
        Arrays.sort(nums);

        // 初始化最接近的和为前三个元素的和
        int closestSum = nums[0] + nums[1] + nums[2];

        // 遍历数组，固定第一个元素
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 使用双指针查找另外两个数
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // 如果找到完全匹配的和直接返回
                if (currentSum == target) {
                    return target;
                }

                // 更新最接近的和
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 根据当前和与目标值的关系调整指针
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
