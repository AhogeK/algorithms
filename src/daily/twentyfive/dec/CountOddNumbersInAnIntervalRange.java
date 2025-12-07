package daily.twentyfive.dec;

/**
 * 1523. 在区间范围内统计奇数数目
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-07 22:58:21
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        return ((high + 1) >> 1) - (low >> 1);
    }
}
