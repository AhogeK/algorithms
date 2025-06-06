package daily.twentyfive.jun;

/**
 * 2434. 使用机器人打印字典序最小的字符串
 *
 * @author AhogeK
 * @since 2025-06-06 19:37:33
 */
public class UsingARobotToPrintTheLexicographicallySmallestString {
    public String robotWithString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i)
            cnt[s.charAt(i) - 'a']++;
        char[] stack = new char[n];
        int top = 0;
        StringBuilder res = new StringBuilder();
        int min = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            stack[top++] = c;
            cnt[c - 'a']--;
            while (min < 26 && cnt[min] == 0)
                min++;
            while (top > 0 && (min == 26 || stack[top - 1] <= (char) ('a' + min))) {
                res.append(stack[--top]);
            }
        }
        return res.toString();
    }
}
