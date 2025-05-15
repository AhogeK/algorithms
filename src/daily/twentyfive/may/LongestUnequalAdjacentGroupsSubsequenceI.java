package daily.twentyfive.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900. 最长相邻不相等子序列 I
 *
 * @author AhogeK
 * @since 2025-05-15 09:56:45
 */
public class LongestUnequalAdjacentGroupsSubsequenceI {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int cur = groups[0];
        ans.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (cur != groups[i]) {
                ans.add(words[i]);
                cur = groups[i];
            }
        }
        return ans;
    }
}
