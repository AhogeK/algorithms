package sort.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-16 23:15:07
 */
public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);   // 取绝对值确保索引正确
            int index = num - 1;           // 计算实际索引
            if (nums[index] < 0) {
                result.add(num);           // 重复时加入结果
            } else {
                nums[index] = -nums[index];// 标记为已访问
            }
        }
        return result;
    }
}
