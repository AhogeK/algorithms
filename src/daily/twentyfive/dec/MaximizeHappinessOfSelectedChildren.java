package daily.twentyfive.dec;

import java.util.Arrays;

/**
 * 3075. 幸福值最大化的选择方案
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-25 08:28:16
 */
public class MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int n = happiness.length;
        for (int i = 0; i < n; i++) {
            int contribution = happiness[n - 1 - i] - i;
            if (contribution > 0)
                sum += contribution;
            else
                break;
        }
        return sum;
    }
}
