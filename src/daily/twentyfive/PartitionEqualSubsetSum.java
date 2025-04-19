package daily.twentyfive;

import java.util.Arrays;

/**
 * @author AhogeK
 * @since 2025-04-07 17:14:05
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        // 非必须，但有助于提前找到解，能有更短的执行用时
        Arrays.sort(nums);

        // 计算数组总和
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // 总和为奇数不存在平均分割
        if (sum % 2 == 1) return false;
        int m = sum / 2;
        // 创建动态规划数组，dp[i]表示是否存在子集的和为i
        boolean[] dp = new boolean[m + 1];
        // 初始化空子集和为0
        dp[0] = true;

        // 对每个元素进行处理
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            // 反向遍历可能的和
            for (int j = m - 1; j >= 0; j--) {
                if (dp[j]) {
                    if (j + cur == m) return true;
                    else if (j + cur < m) dp[j + cur] = true;
                }
            }
        }
        return false;
    }
}
