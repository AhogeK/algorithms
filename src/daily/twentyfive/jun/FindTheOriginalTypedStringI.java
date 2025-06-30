package daily.twentyfive.jun;

/**
 * 3330. 找到初始输入字符串 I
 *
 * @author AhogeK
 * @since 2025-07-01 04:27:16
 */
public class FindTheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ans++;
            }
        }
        return ans;
    }
}
