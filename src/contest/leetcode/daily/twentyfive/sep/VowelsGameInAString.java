package contest.leetcode.daily.twentyfive.sep;

/**
 * 3227. 字符串元音游戏
 *
 * @author AhogeK
 * @since 2025-09-12 16:03:43
 */
public class VowelsGameInAString {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        }
        return false;
    }
}
