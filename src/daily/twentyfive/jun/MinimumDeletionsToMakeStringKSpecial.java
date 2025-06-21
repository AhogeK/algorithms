package daily.twentyfive.jun;

import java.util.Arrays;

/**
 * 3085. 成为 K 特殊字符串需要删除的最少字符数
 *
 * @author AhogeK
 * @since 2025-06-21 19:57:03
 */
public class MinimumDeletionsToMakeStringKSpecial {
    public int minimumDeletions(String word, int k) {
        int[] counts = new int[26];
        int n = word.length();
        int ans = n;
        int preSum = 0;
        for (int i = 0; i < n; i++)
            counts[word.charAt(i) - 'a']++;
        Arrays.sort(counts);
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0)
                continue;
            int end = counts[i] + k;
            int tmpAns = preSum;
            for (int j = i + 1; j < 26; j++)
                if (counts[j] > end)
                    tmpAns += counts[j] - end;
            ans = Math.min(ans, tmpAns);
            preSum += counts[i];
        }
        return ans;
    }
}
