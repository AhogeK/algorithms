package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AhogeK
 * @since 2025-03-17 21:50:10
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // 哈希表存储字符及其最新索引
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0; // 记录最大长度
        int left = 0; // 窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果字符已存在且在当前窗口内，更新左边界
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar) + 1;
            }

            // 更新字符的最新索引
            charIndex.put(currentChar, right);

            // 计算当前窗口长度并更新最大值
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
