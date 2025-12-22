package dynamic;

/**
 * LCR 126. 斐波那契数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-22 10:28:15
 */
public class Fib {
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0;
        int b = 1;
        final int MOD = 1000000007;
        for (int i = 2; i <= n; i++) {
            int sum = (a + b) % MOD;
            a = b;
            b = sum;
        }
        return b;
    }
}
