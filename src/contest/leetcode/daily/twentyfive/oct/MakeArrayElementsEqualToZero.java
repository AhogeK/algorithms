package contest.leetcode.daily.twentyfive.oct;

/**
 * 3354. 使数组元素等于零
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2025-10-28 16:15:50
 */
public class MakeArrayElementsEqualToZero {
    public int countValidSelections(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int ans = 0;
        int leftSum = 0;
        for (int num : nums) {
            if (num == 0) {
                int rightSum = totalSum - leftSum;
                if (leftSum == rightSum) ans += 2;
                else if (Math.abs(leftSum - rightSum) == 1) ans++;
            }
            leftSum += num;
        }
        return ans;
    }
}
