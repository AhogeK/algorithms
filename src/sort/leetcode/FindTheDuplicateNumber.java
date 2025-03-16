package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-16 22:42:50
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // 初始化快慢指针
        int slow = nums[0];
        int fast = nums[0];

        // 第一阶段：检测环的存在
        do {
            slow = nums[slow];          // 慢指针步长1
            fast = nums[nums[fast]];    // 快指针步长2
        } while (slow != fast);

        // 第二阶段：寻找环入口
        fast = nums[0]; // 重置快指针到起点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;    // 环入口即重复数
    }
}
