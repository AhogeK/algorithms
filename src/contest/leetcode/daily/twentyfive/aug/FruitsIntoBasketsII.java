package contest.leetcode.daily.twentyfive.aug;

/**
 * 3477. 水果成篮 II
 *
 * @author AhogeK
 * @since 2025-08-05 23:44:17
 */
public class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = baskets.length;
        for (int fruit : fruits) {
            int unset = 1;
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    unset = 0;
                    break;
                }
            }
            count += unset;
        }
        return count;
    }
}
