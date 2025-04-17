package daily.twentyfive.april;

/**
 * 2176. 统计数组中相等且可以被整除的数对
 *
 * @author AhogeK
 * @since 2025-04-17 18:12:19
 */
public class CountEqualAndDivisiblePairsInAnArray {

    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] == nums[j] && i * j % k == 0)
                    ans++;

        return ans;
    }
}
