package daily.twentyfive.aug;

/**
 * 808. 分汤
 *
 * @author AhogeK
 * @since 2025-08-08 20:32:30
 */
public class SoupServings {
    public double soupServings(int n) {
        if (n >= 4800)
            return 1.0;

        int N = (n + 24) / 25;

        double[][] memo = new double[N + 1][N + 1];

        return dfs(N, N, memo);
    }

    private double dfs(int a, int b, double[][] memo) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1.0;
        if (b <= 0)
            return 0.0;

        if (memo[a][b] > 0)
            return memo[a][b];

        memo[a][b] = 0.25 * (dfs(a - 4, b, memo) +
                dfs(a - 3, b - 1, memo) +
                dfs(a - 2, b - 2, memo) +
                dfs(a - 1, b - 3, memo));
        return memo[a][b];
    }
}
