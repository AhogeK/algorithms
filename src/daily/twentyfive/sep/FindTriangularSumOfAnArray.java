package daily.twentyfive.sep;

/**
 * 2221. 数组的三角和
 *
 * @author AhogeK
 * @since 2025-09-30 19:19:10
 */
public class FindTriangularSumOfAnArray {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
