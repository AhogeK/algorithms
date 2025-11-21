package daily.twentyfive.nov;

/**
 * 1930. 长度为 3 的不同回文子序列
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-21 22:02:05
 */
public class UniqueLengthThreePalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int idx = chars[i] - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1 || last[i] <= first[i] + 1) {
                continue;
            }

            boolean[] seen = new boolean[26];
            int distinctCount = 0;

            for (int j = first[i] + 1; j < last[i]; j++) {
                int charIndex = chars[j] - 'a';
                if (!seen[charIndex]) {
                    seen[charIndex] = true;
                    distinctCount++;
                    if (distinctCount == 26) break;
                }
            }
            ans += distinctCount;
        }

        return ans;
    }
}
