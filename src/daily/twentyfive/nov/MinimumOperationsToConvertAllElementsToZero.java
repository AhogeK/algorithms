package daily.twentyfive.nov;

/**
 * 3542. 将所有元素变为 0 的最少操作次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-10 19:34:09
 */
public class MinimumOperationsToConvertAllElementsToZero {
    public int minOperations(int[] nums) {
        int ans = 0;
        int top = -1;
        for (int x : nums) {
            while (top >= 0 && x < nums[top]) {
                top--;
                ans++;
            }
            if (top < 0 || x != nums[top]) {
                nums[++top] = x;
            }
        }
        return ans + top + (nums[0] > 0 ? 1 : 0);
    }
}
