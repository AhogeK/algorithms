package dynamic;

/**
 * 91. 解码方法
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-26 15:16:53
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        char[] a = s.toCharArray();
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            if (a[i - 1] != '0') cur += prev1;
            int two = (a[i - 2] - '0') * 10 + (a[i - 1] - '0');
            if (two >= 10 && two <= 26) cur += prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
