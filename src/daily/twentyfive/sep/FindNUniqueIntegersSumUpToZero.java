package daily.twentyfive.sep;

/**
 * 1304. 和为零的 N 个不同整数
 *
 * @author AhogeK
 * @since 2025-09-07 03:45:55
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i * 2 - n + 1;
        }
        return res;
    }
}
