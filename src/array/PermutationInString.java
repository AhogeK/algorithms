package array;

/**
 * @author AhogeK
 * @since 2025-03-20 22:42:16
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] hash = new int[26];
        // 统计s1字符频率
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }

        // 初始化剩余需要匹配的字符数
        int requiredChars = len1;

        // 处理初始窗口（s2的前len1个字符）
        for (int i = 0; i < len1; i++) {
            int idx = s2.charAt(i) - 'a';
            // 若该字符是s1需要的，减少需匹配数
            if (hash[idx]-- > 0) {
                requiredChars--;
            }
        }
        if (requiredChars == 0) return true;

        // 滑动窗口：每次移动一位
        for (int right = len1; right < len2; right++) {
            int leftChar = s2.charAt(right - len1) - 'a'; // 是要移出的，所以长度还是2
            int rightChar = s2.charAt(right) - 'a';

            // 处理左边界字符移出
            if (hash[leftChar]++ >= 0) { // 若该字符原属于s1，需恢复匹配需求
                requiredChars++;
            }

            if (hash[rightChar]-- > 0) { // 若该字符是s1需要的，减少需匹配数
                requiredChars--;
            }

            if (requiredChars == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        permutationInString.checkInclusion(s1, s2);
    }
}
