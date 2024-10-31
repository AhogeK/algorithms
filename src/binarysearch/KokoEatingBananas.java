package binarysearch;

/**
 * 875. 爱吃香蕉的珂珂
 * <a href="https://leetcode-cn.com/problems/koko-eating-bananas/">题目链接</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-05-16 15:23:48
 */
public class KokoEatingBananas {

    /**
     * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
     * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉
     * 少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然希望在回家前吃掉所有的香蕉。
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     *
     * @param piles 香蕉堆
     * @param h     可以吃掉所有香蕉的时间
     * @return 吃掉所有香蕉的最小速度
     */
    public int minEatingSpeed(int[] piles, int h) {
        // 确定范围的上界，即吃掉所有香蕉的最大速度
        int max = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        // 二分查找来查找最小速度
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            } else {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 判断是否能在 h 小时内以 speed 的速度吃完香蕉
     *
     * @param piles 香蕉堆
     * @param h     可以吃掉所有香蕉的时间
     * @param speed 吃香蕉的速度
     * @return 是否能在 h 小时内以 speed 的速度吃完香蕉
     */
    private boolean canFinish(int[] piles, int h, int speed) {
        int time = 0;
        for (int pile : piles) {
            // 因为会有不是整除的情况，因此不使用 pile / speed 而是 (pile - 1) / speed + 1
            time += (pile - 1) / speed + 1;
        }
        return time <= h;
    }

    public int minEatingSpeed2(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) right = Math.max(right, pile);
        while (left < right) {
            int mid = left + (right - left) / 2;

            boolean check = true;
            int totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
                if (totalHours > h) {
                    check = false;
                    break;
                }
            }

            if (check) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
