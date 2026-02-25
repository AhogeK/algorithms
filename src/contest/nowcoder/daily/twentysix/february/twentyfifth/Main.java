package contest.nowcoder.daily.twentysix.february.twentyfifth;

import java.io.IOException;
import java.io.InputStream;

/**
 * <a href="https://www.nowcoder.com/practice/c245af6cfdce49ceb5435f649ee14f89?channelPut=tracker2">斐波那契数列</a>
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-25 12:46:42
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        int k = 0;
        int b = is.read();
        while (b < '0' || b > '9') b = is.read();
        while (b >= '0' && b <= '9') {
            k = k * 10 + (b - '0');
            b = is.read();
        }
        if (k == 1 || k == 2) {
            System.out.println(1);
            return;
        }
        int mod = 1_000_000_007;
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 3; i <= k; i++) {
            int current = prev1 + prev2;
            if (current >= mod) current -= mod; // current % mod;
            prev2 = prev1;
            prev1 = current;
        }
        System.out.println(prev1);
    }
}
