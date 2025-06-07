package daily.twentyfive.jun;

/**
 * 3170. 删除星号以后字典序最小的字符串
 *
 * @author AhogeK
 * @since 2025-06-07 20:19:36
 */
public class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        int n = s.length();
        int[][] stack = new int[26][n];
        int[] top = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            char c = arr[i];
            if (c != '*') {
                int v = c - 'a';
                stack[v][top[v]++] = i;
            } else {
                for (int v = 0; v < 26; ++v) {
                    if (top[v] > 0) {
                        arr[stack[v][--top[v]]] = '*';
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            if (c != '*')
                sb.append(c);
        return sb.toString();
    }
}
