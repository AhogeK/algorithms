package contest.leetcode.daily.twentyfive.jun;

/**
 * 2929. 给小朋友们分糖果 II
 *
 * @author AhogeK
 * @since 2025-06-01 18:43:26
 */
public class DistributeCandiesAmongChildrenII {
    public long cal(int x) {
        if (x < 0) return 0;
        return (long) x * (x - 1) / 2;
    }

    public long distributeCandies(int n, int limit) {
        int d = limit + 1;
        return cal(n + 2) - 3 * cal(n - d + 2) + 3 * cal(n - 2 * d + 2) - cal(n - 3 * d + 2);
    }
}
