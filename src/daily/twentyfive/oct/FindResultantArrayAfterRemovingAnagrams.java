package daily.twentyfive.oct;

import java.util.ArrayList;
import java.util.List;

/**
 * 2273. 移除字母异位词后的结果数组
 *
 * @author AhogeK
 * @since 2025-10-13 15:49:14
 */
public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        for (int x : cnt) {
            if (x != 0)
                return false;
        }
        return true;
    }
}
