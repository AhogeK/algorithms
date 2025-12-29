package contest.leetcode.daily.twentyfive.sep;

/**
 * 3516. 找到最近的人
 *
 * @author AhogeK
 * @since 2025-09-04 09:30:45
 */
public class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        int sq1 = (x - z) * (x - z);
        int sq2 = (y - z) * (y - z);
        return sq1 < sq2 ? 1 : sq1 > sq2 ? 2 : 0;
    }
}
