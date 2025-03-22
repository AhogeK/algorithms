package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-21 21:17:04
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 处理边界情况
        if (nums == null || nums.length < 3) return result;

        // 先对数组进行排序
        Arrays.sort(nums);

        int n = nums.length;

        // 遍历数组，固定第一个数
        for (int i = 0; i < n - 2; i++) {
            // 如果当前数字大于0，因为数组已排序，后面的数字都比它大，三数之和必然大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }

            // 去重：跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 使用双指针在剩余数组中寻找两个数
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    // 和小于0，需要增大，左指针右移
                    left++;
                } else if (sum > 0) {
                    // 和大于0，需要减少，右指针左移
                    right--;
                } else {
                    // 找到一组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重，跳过重复的左右指针指向的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 指针同时移动，继续寻找其他解
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
