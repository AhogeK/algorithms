package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/">
 * 「力扣」1482. 制作 m 束花所需的最少天数
 * </a>
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现在你需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束花 中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 18:41:06
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE, right = 0;

        // 确定二分查找左右边界
        for (int bloom : bloomDay) {
            left = Math.min(left, bloom);
            right = Math.max(right, bloom);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            // 确认当前天数下能否制作出 m 束花
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return canMake(bloomDay, m, k, left) ? left : -1;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;

        // 计算在 'days' 天内可以制作的花束数量
        for (int bloom : bloomDay) {
            if (bloom <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
