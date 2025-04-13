package daily;

/**
 * @author AhogeK
 * @since 2025-04-13 09:30:48
 */
public class CountGoodNumbers {
    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        // 偶数位数量
        long evenCount = (n + 1) /2;
        // 奇数位数量
        long oddCount = n / 2;
        long power5 = fastPow(5, evenCount);
        long power4 = fastPow(4, oddCount);
        return (int) ((power5 * power4) % MOD);
    }

    // 快速幂算法
    private long fastPow(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1;
        }
        return result;
    }
}
