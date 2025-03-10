package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-10 15:57:54
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        // 处理特殊情况
        if (nums.length <= 2) return nums.length;

        int slow = 2; // 慢指针，指向应该放置新元素的位置

        // 从第三个元素开始遍历
        for (int fast = 2; fast < nums.length; fast++) {
            // 判断当前元素是否保留
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            // 如果当前元素与slow-2的位置的元素相同，说明是第3次出现，跳过
        }

        return slow;
    }
}
