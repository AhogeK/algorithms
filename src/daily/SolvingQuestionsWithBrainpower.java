package daily;

/**
 * <a href="https://leetcode.cn/problems/solving-questions-with-brainpower">2140. 解决智力问题</a>
 *
 * @author AhogeK
 * @since 2025-04-01 15:01:15
 */
public class SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // dp[i] 表示从第 i 个问题到最后，能获得的最大分数
        long[] dp = new long[n + 1];

        // 从后往前遍历，自底向上计算dp
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];

            // 计算解决问题 i 后的下一个可解决问题的索引
            int nextIndex = i + brainpower + 1;

            // 如果下一个在范围内进行叠加
            if (nextIndex < n) {
                dp[i] = points + dp[nextIndex];
            } else {
                dp[i] = points;
            }

            // 为了一遍遍历拿到结果只取最大值
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        SolvingQuestionsWithBrainpower solution = new SolvingQuestionsWithBrainpower();
        System.out.println(solution.mostPoints(questions));
    }
}
