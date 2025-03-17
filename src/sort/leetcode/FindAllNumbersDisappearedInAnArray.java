package sort.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-17 21:02:58
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // 第一次遍历：标记已出现数字的索引位置
        for (int num : nums) {
            int index = Math.abs(num) - 1; // 取绝对值避免索引越界
            if (nums[index] > 0) { // 避免重复取反
                nums[index] = -nums[index]; // 标记为负数
            }
        }
        // 第二次遍历：收集未标记的索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // 索引i对应数字i+1未出现
            }
        }
        return result;
    }
}
