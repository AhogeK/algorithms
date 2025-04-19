package daily.twentyfive;

/**
 * @author AhogeK
 * @since 2025-04-12 05:48:14
 */
public class FindTheCountOfGoodIntegers {
    // 用于记录已处理过的数字组合
    boolean[] visitedMap;
    // 最终答案
    long resultCount;
    // 组合计算的缓存
    int[][] combCache;

    public long countGoodIntegers(int n, int k) {
        if (n == 1) return 9 / k;

        if (n == 2) {
            long res = 0;

            // 两位数回文均为AA
            for (int v = 11; v < 100; v += 11)
                if (v % k == 0) res++;

            return res;
        }

        int startDigit = 1;
        if (k % 2 == 0) startDigit = 2;
        else if (k == 5) startDigit = 5;

        int halfLength = (n + 1) >>> 1;

        // 同余原理: 如果两个数除以 k 的余数相同，那么它们对模 k 同余 => a ≡ b (mod k)
        // 因此如果 a ≡ b (mod k) 且 c ≡ d (mod k)，那么 a + c ≡ b + d (mod k); a * c ≡ b * d (mod k)
        // 例如 123 = 1 * 10 ^ 2 + 2 * 10 ^ 1 + 3 * 10 ^ 0
        // 也就是 123 mod k = ((1 * 10 ^ 2) mod k + (2 * 10 ^ 1) mod k + (3 * 10 ^ 0) mod k) mod k
        // 那么 (digit) * (10 ^ i mod k) 相当于第i位的贡献
        // 回文中的优化也就是i和n-1-i的组合贡献: (digit) * ((10 ^ i mod k) + (10 ^ (n - 1 - i) mod k))
        int[] remainders = new int[halfLength];
        int power = 1;
        for (int i = 0; i < n; i++) {
            // 确定对称位置
            int position = Math.min(i, n - 1 - i);
            remainders[position] = (remainders[position] + power) % k;
            power = power * 10 % k;
        }

        // 初始化数据结构
        int base = 1;
        for (int i = 0; i < halfLength; i++)
            base *= 10;
        visitedMap = new boolean[n % 2 == 0 ? base : base * 10];
        combCache = new int[n + 1][n + 1];

        // 初始化数学计数数组并开始DFS
        int[] digitCounts = new int[10]; // 0-9的次数
        for (int firstDigit = startDigit; firstDigit < 10; firstDigit += startDigit) {
            digitCounts[firstDigit] = 2; // 前后
            dfs(digitCounts, remainders, 1, n, k, firstDigit * remainders[0] % k);
            digitCounts[firstDigit] = 0; // 回溯
        }

        return resultCount;
    }

    // 深度优先搜索构建回文数
    private void dfs(int[] digitCounts, int[] remainders, int index, int n, int k, int currentRemainder) {
        if ((index + 1) * 2 >= n) {
            int count = 2 - (n & 1); // 奇数1次偶数2次
            for (int digit = 0; digit <= 9; digit++) {
                if ((remainders[index] * digit + currentRemainder) % k == 0) {
                    digitCounts[digit] += count;
                    checkResult(digitCounts, n, count == 1 ? digit : 0);
                    digitCounts[digit] -= count;
                }
            }
        } else {
            for (int digit = 0; digit <= 9; digit++) {
                digitCounts[digit] += 2; // 对称位置同时添加
                dfs(digitCounts, remainders, index + 1, n, k,
                        (remainders[index] * digit + currentRemainder) % k);
                digitCounts[digit] -= 2; // 回溯
            }
        }
    }

    // 检查并计算当前数字组合能形成的好整数数量
    private void checkResult(int[] digitCounts, int n, int middleDigit) {
        // 计算哈希键以检查是否已处理过此组合
        int key = middleDigit;
        for (int i = 0; i <= 9; i++) {
            int count = digitCounts[i] >>> 1;
            while (count > 0) {
                key = key * 10 + i;
                count--;
            }
        }

        // 如果已经处理进行跳过
        if (visitedMap[key]) return;
        visitedMap[key] = true;

        int totalDigits = n;
        long ways = 1;

        // 处理0，它不能作为首位
        if (digitCounts[0] != 0) {
            ways = combination(totalDigits - 1, digitCounts[0]);
            totalDigits -= digitCounts[0];
        }

        for (int d = 1; d <= 9; d++) {
            int count = digitCounts[d];
            if (count > 0) {
                ways *= combination(totalDigits, count);
                totalDigits -= count;
            }
        }

        resultCount += ways;
    }

    // 计算组合数 C(n, m)
    private long combination(int n, int m) {
        // 检查缓存
        int cached = combCache[n][m];
        if (cached != 0) return cached;

        m = Math.min(m, n - m);
        int result = 1;
        for (int i = 0; i < m; i++)
            result = result * (n - i) / (i + 1);

        // 保存到缓存
        combCache[n][m] = combCache[n][n - m] = result;
        return result;
    }
}
