package daily;

/**
 * @author AhogeK
 * @since 2025-04-08 06:53:35
 */
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        int index = 0;
        int[] count = new int[101]; // 因为值域为 1 <= nums[i] <= 100

        // 统计频率
        for (int num : nums) count[num]++;

        // 循环到所有元素唯一
        while (hasDuplicates(count)) {
            // 移除前三个元素，从当前index开始
            for (int i = index; i < Math.min(index + 3, n); i++) {
                count[nums[i]]--; // 更新频率
            }
            index += 3;
            res++;
        }
        return res;
    }

    /**
     * 检查是否存在重复元素
     */
    private boolean hasDuplicates(int[] count) {
        // 频率大于1，说明有重复元素
        for (int c : count) if (c > 1) return true;
        return false;
    }
}
