package daily.twentyfive.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * 2438. 二的幂数组中查询范围内的乘积
 *
 * @author AhogeK
 * @since 2025-08-11 23:01:51
 */
public class RangeProductQueriesOfPowers {
    private static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int power = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(1 << power);
            }
            n >>= 1;
            power++;
        }

        int m = powers.size();
        int[][] product = new int[m][m];
        for (int i = 0; i < m; i++) {
            long result = 1;
            for (int j = i; j < m; j++) {
                result = (result * powers.get(j)) % MOD;
                product[i][j] = (int) result;
            }
        }

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            answers[i] = product[queries[i][0]][queries[i][1]];
        return answers;
    }
}
