package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-20 20:12:00
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] currentCount = new int[26];
        int valid = 0; // 记录满足频率要求的字符种类数
        int uniqueChars = 0; // p中不同字符的数量

        // 统计p的字符频率
        for (char c : p.toCharArray()) {
            if (pCount[c - 'a'] == 0) uniqueChars++;
            pCount[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            currentCount[c - 'a']++;

            // 当新增字符的频率与p中该字符的频率一致时，valid增加
            if (currentCount[c - 'a'] == pCount[c - 'a']) {
                valid++;
            }

            // 窗口大小超过p长度时，左指针右移
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                if (currentCount[leftChar - 'a'] == pCount[leftChar - 'a']) {
                    valid--;
                }
                currentCount[leftChar - 'a']--;
                left++;
            }

            // 当窗口大小等于p长度且valid匹配时，记录索引
            if (right - left + 1 == p.length() && valid == uniqueChars) {
                result.add(left);
            }
        }

        return result;
    }
}
