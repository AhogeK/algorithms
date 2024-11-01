package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/xiao-zhang-shua-ti-ji-hua/">
 * LCP 12. 小张刷题计划
 * </a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 19:11:54
 */
public class XiaozhangCodingPracticePlan {

    public int minTime(int[] time, int m) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 判断 mid 的每天耗时能否在 m 天完成所有的times列表道题
            if (check(time, m, mid)) {
                // 可以的话缩小mid的区间
                right = mid - 1;
            } else {
                // 反正扩大 mid 的每天耗时
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] time, int m, int mid) {
        int maxTime = 0;
        int total = 0;
        int days = 1;
        boolean helper = true;
        for (int i = 0; i < time.length; i++) {
            maxTime = Math.max(maxTime, time[i]);
            total += time[i];
            if (total > mid) {
                if (helper) {
                    total -= maxTime;
                    helper = false;
                } else {
                    days++;
                    helper = true;
                    maxTime = 0;
                    total = 0;
                    i--;
                }
            }
        }
        return m >= days;
    }

    public int minTime2(int[] time, int m) {
        int left = 0, right = 0;
        for (int t : time) {
            right += t;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = 1;
            int sum = 0;
            int maxTime = 0;
            for (int t : time) {
                sum += t;
                maxTime = Math.max(maxTime, t);
                if (sum - maxTime > mid) {
                    days++;
                    sum = t;
                    maxTime = t;
                }
            }
            if (days > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
