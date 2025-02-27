package sort.leetcode;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/"></a>
 *
 * @author AhogeK
 * @since 2025-02-27 15:20:36
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) if (nums[fast] != 0) nums[slow++] = nums[fast];
        while (slow < nums.length) nums[slow++] = 0;
    }
}
