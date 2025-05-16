package daily.twentyfive.may;

import java.util.*;

/**
 * 2901. 最长相邻不相等子序列 II
 *
 * @author AhogeK
 * @since 2025-05-16 17:03:13
 */
public class LongestUnequalAdjacentGroupsSubsequenceII {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String>[] dp = new List[n];
        Map<String, List<Integer>> dict = new HashMap<>();
        List<String> res = null;
        for (int i = n - 1; i >= 0; i--) {
            char[] cs = words[i].toCharArray();
            int max = 0;
            int select = -1;
            for (int j = 0; j < cs.length; j++) {
                char orig = cs[j];
                cs[j] = '.';
                String key = new String(cs);
                for (int next : dict.getOrDefault(key, Collections.emptyList())) {
                    if (orig != words[next].charAt(j) && groups[i] != groups[next] && dp[next].size() > max) {
                        max = dp[next].size();
                        select = next;
                    }
                }
                cs[j] = orig;
            }
            dp[i] = new ArrayList<>();
            dp[i].add(words[i]);
            if (select != -1) dp[i].addAll(dp[select]);
            for (int j = 0; j < cs.length; j++) {
                char orig = cs[j];
                cs[j] = '.';
                dict.computeIfAbsent(new String(cs), s -> new ArrayList<>()).add(i);
                cs[j] = orig;
            }
            if (res == null || dp[i].size() > res.size()) res = dp[i];
        }
        return res;
    }
}
