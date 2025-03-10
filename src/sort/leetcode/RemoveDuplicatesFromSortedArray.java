package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-10 15:41:17
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // 处理空数组情况
        if (nums.length == 0) return 0;

        int slow = 0; // 慢指针，指向新数组末尾

        // 从第二个元素开始遍历，因为第一个必定没有重复
        for (int fast = 1; fast < nums.length; fast++) {
            // 发现不重复元素
            if (nums[fast] != nums[slow]) {
                // 慢指针向前移动，并保存这个不重复元素
                slow++;
                nums[slow] = nums[fast];
            }
            // 重复元素会被跳过
        }

        // 新数组的长度
        return slow + 1;
    }
}
