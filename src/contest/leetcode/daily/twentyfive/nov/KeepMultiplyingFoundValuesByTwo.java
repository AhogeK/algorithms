package contest.leetcode.daily.twentyfive.nov;

/**
 * 2154. 将找到的值乘以 2
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-19 14:54:58
 */
public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        boolean[] seen = new boolean[1001];
        for (int num : nums) seen[num] = true;
        while (original <= 1000 && seen[original])
            original *= 2;
        return original;
    }
}
