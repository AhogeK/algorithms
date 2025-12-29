package contest.leetcode.daily.twentyfive.aug;

import java.util.HashSet;

/**
 * 869. 重新排序得到 2 的幂
 *
 * @author AhogeK
 * @since 2025-08-10 22:34:36
 */
public class ReorderedPowerOf2 {
    HashSet<String> powerOf2Digits = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    private void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {
            powerOf2Digits.add(countDigits(n));
        }
    }

    private String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }
}
