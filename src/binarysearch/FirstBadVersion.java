package binarysearch;

/**
 * 「力扣」278. 第一个错误的版本
 * <a href="https://leetcode.cn/problems/first-bad-version/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:28:45
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于最右边的值，说明最小值在右边
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 此时 left == right，所以最小值为 nums[left] 或者 nums[right]
        return left;
    }
}
