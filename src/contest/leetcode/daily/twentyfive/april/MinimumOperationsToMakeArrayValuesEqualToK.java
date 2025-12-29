package contest.leetcode.daily.twentyfive.april;

import java.util.HashSet;
import java.util.Set;

/**
 * 3375
 *
 * @author AhogeK
 * @since 2025-04-09 09:58:54
 */
public class MinimumOperationsToMakeArrayValuesEqualToK {

    public int minOperations(int[] nums, int k) {
        Set<Integer> uniqueValues = new HashSet<>();

        for (int num : nums) {
            if (num < k) return - 1;
            if (num > k) uniqueValues.add(num);
        }

        return uniqueValues.size();
    }
}
