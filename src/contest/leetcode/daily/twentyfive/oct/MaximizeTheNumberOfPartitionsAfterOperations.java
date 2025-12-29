package contest.leetcode.daily.twentyfive.oct;

/**
 * 3003. 执行操作后的最大分割数量
 *
 * @author AhogeK
 * @since 2025-10-17 18:50:47
 */
public class MaximizeTheNumberOfPartitionsAfterOperations {
    int num = 0, mask = 0, count = 0;

    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];

        for (int i = 0; i < n - 1; i++) {
            operation(s, k, i);
            left[i + 1][0] = num;
            left[i + 1][1] = mask;
            left[i + 1][2] = count;
        }

        num = 0;
        mask = 0;
        count = 0;
        for (int i = n - 1; i > 0; i--) {
            operation(s, k, i);
            right[i - 1][0] = num;
            right[i - 1][1] = mask;
            right[i - 1][2] = count;
        }

        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int seg = left[i][0] + right[i][0] + 2;
            int totMask = left[i][1] | right[i][1];
            int totCount = Integer.bitCount(totMask);
            if (left[i][2] == k && right[i][2] == k && totCount < 26) {
                seg++;
            } else if (Math.min(totCount + 1, 26) <= k) {
                seg--;
            }
            maxVal = Math.max(maxVal, seg);
        }
        return maxVal;
    }

    private void operation(String s, int k, int i) {
        int binary = 1 << (s.charAt(i) - 'a');
        if ((mask & binary) == 0) {
            count++;
            if (count <= k) {
                mask |= binary;
            } else {
                num++;
                mask = binary;
                count = 1;
            }
        }
    }
}
