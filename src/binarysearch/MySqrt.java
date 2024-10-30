package binarysearch;

/**
 * 「力扣」第 69 题：x 的平方根
 * <a href="https://leetcode-cn.com/problems/sqrtx/">题目地址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-28 23:25:54
 */
public class MySqrt {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 防止乘法溢出
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;

        int left = 1;
        int right = x / 2 + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
