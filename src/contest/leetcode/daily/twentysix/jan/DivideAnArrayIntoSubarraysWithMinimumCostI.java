package contest.leetcode.daily.twentysix.jan;

/**
 * 3010. 将数组分成最小总代价的子数组 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-01 20:31:46
 */
public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public int minimumCost(int[] nums) {
        int smallest = 100, secondSmallest = 100;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < smallest) {
                secondSmallest = smallest;
                smallest = x;
            } else if (x < secondSmallest) secondSmallest = x;
        }
        return nums[0] + smallest + secondSmallest;
    }
}
