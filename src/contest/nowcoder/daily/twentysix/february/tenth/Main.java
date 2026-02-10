package contest.nowcoder.daily.twentysix.february.tenth;

import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/ee287e0f6af64edd969f01444dd763e4?channelPut=tracker2">小红的二叉树</a>
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-11 00:06:34
 */
public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        if (n <= 1) return 0;
        long pow = modPow(2, n - 1);
        return (3 * pow % MOD - 5 + MOD) % MOD;
    }

    private static long modPow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}
