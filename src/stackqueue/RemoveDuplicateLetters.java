package stackqueue;

/**
 * 316. 去除重复字母
 *
 * @author AhogeK
 * @since 2025-05-18 18:25:34
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] array = s.toCharArray();
        int[] left = new int[26];
        for (char c : array)
            left[c - 'a']++;
        StringBuilder ans = new StringBuilder();
        boolean[] inAns = new boolean[26];
        for (char c : array) {
            left[c - 'a']--;
            if (inAns[c - 'a'])
                continue;
            while (!ans.isEmpty() &&
                    c < ans.charAt(ans.length() - 1) &&
                    left[ans.charAt(ans.length() - 1) - 'a'] > 0) {
               inAns[ans.charAt(ans.length() - 1) - 'a'] = false;
               ans.deleteCharAt(ans.length() - 1);
            }
            ans.append(c);
            inAns[c - 'a'] = true;
        }
        return ans.toString();
    }
}
