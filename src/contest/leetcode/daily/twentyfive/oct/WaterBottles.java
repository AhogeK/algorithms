package contest.leetcode.daily.twentyfive.oct;

/**
 * 1518. 换水问题
 *
 * @author AhogeK
 * @since 2025-10-01 19:50:55
 */
public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            totalDrunk += newBottles;
            empty = newBottles + empty % numExchange;
        }
        return totalDrunk;
    }
}
