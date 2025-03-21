package array;

/**
 * @author AhogeK
 * @since 2025-03-21 20:55:51
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, result = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']); // 更新当前窗口的最大出现次数

            // 若窗口不满足条件，收缩左边界
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--; // 移除左边界字符
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
