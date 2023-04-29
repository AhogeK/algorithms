package binarysearch;

/**
 * 「力扣」第 287 题：寻找重复数
 * <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/">题目地址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-29 17:39:52
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
